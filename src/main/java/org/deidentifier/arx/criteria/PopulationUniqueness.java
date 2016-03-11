/*
 * ARX: Powerful Data Anonymization
 * Copyright 2012 - 2015 Florian Kohlmayer, Fabian Prasser
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.deidentifier.arx.criteria;

import org.deidentifier.arx.ARXPopulationModel;
import org.deidentifier.arx.ARXSolverConfiguration;
import org.deidentifier.arx.framework.check.groupify.HashGroupifyDistribution;
import org.deidentifier.arx.risk.RiskModelPopulationUniqueness;
import org.deidentifier.arx.risk.RiskModelPopulationUniqueness.PopulationUniquenessModel;

/**
 * This criterion ensures that the population uniqueness falls below a given threshold.
 * 
 * @author Fabian Prasser
 */
public class PopulationUniqueness extends RiskBasedCriterion{

    /** SVUID */
    private static final long          serialVersionUID = 618039085843721351L;

    /** The statistical model */
    private PopulationUniquenessModel statisticalModel;

    /** The population model */
    private ARXPopulationModel         populationModel;

    /** The solver config*/
    private ARXSolverConfiguration     solverConfig;
    
    /**
     * Creates a new instance of this criterion. Uses Dankar's method for estimating population uniqueness.
     * This constructor will clone the population model, making further changes to it will not influence
     * the results. The default accuracy is 10e-6 and the default maximal number of iterations is 1000.
     *  
     * @param riskThreshold
     * @param populationModel
     */
    public PopulationUniqueness(double riskThreshold, ARXPopulationModel populationModel){
        this(riskThreshold, PopulationUniquenessModel.DANKAR, populationModel);
    }

    /**
     * Creates a new instance of this criterion. Uses Dankar's method for estimating population uniqueness.
     * This constructor will clone the population model, making further changes to it will not influence
     * the results.
     *  
     * @param riskThreshold
     * @param populationModel
     * @param config
     */
    public PopulationUniqueness(double riskThreshold,
                                               ARXPopulationModel populationModel,
                                               ARXSolverConfiguration config) {
        this(riskThreshold, PopulationUniquenessModel.DANKAR, populationModel, config);
    }

    /**
     * Creates a new instance of this criterion. Uses the specified method for estimating population uniqueness.
     * This constructor will clone the population model, making further changes to it will not influence
     * the results.
     * 
     * @param riskThreshold
     * @param statisticalModel
     * @param populationModel
     */
    public PopulationUniqueness(double riskThreshold,
                                               PopulationUniquenessModel statisticalModel, 
                                               ARXPopulationModel populationModel){
        this(riskThreshold, statisticalModel, populationModel, ARXSolverConfiguration.create());
    }
    /**
     * Creates a new instance of this criterion. Uses the specified method for estimating population uniqueness.
     * This constructor will clone the population model, making further changes to it will not influence
     * the results. The default accuracy is 10e-6 and the default maximal number of iterations is 1000.
     * 
     * @param riskThreshold
     * @param statisticalModel
     * @param populationModel
     * @param config
     */
    public PopulationUniqueness(double riskThreshold,
                                               PopulationUniquenessModel statisticalModel, 
                                               ARXPopulationModel populationModel,
                                               ARXSolverConfiguration config){
        super(false, statisticalModel == PopulationUniquenessModel.ZAYATZ, riskThreshold);
        this.statisticalModel = statisticalModel;
        this.populationModel = populationModel.clone();
        this.solverConfig = config;
    }

    /**
     * @return the populationModel
     */
    public ARXPopulationModel getPopulationModel() {
        return populationModel;
    }

    /**
     * @return the statisticalModel
     */
    public PopulationUniquenessModel getStatisticalModel() {
        return statisticalModel;
    }

    @Override
    public String toString() {
        return "(<" + getRiskThreshold() + "-population-uniques (" + statisticalModel.toString().toLowerCase() + ")";
    }

    /**
     * We currently assume that at any time, at least one statistical model converges.
     * This might not be the case, and 0 may be returned instead. That's why we only
     * accept estimates of 0, if the number of equivalence classes of size 1 in the sample is also zero
     * 
     * @param distribution
     * @return
     */
    protected boolean isFulfilled(HashGroupifyDistribution distribution) {

        RiskModelPopulationUniqueness riskModel = new RiskModelPopulationUniqueness(this.populationModel, 
                                                                                                      distribution.getEquivalenceClasses(), 
                                                                                                      distribution.getNumberOfTuples(),
                                                                                                      solverConfig);
        
        double populationUniques = 0d;
        if (this.statisticalModel == PopulationUniquenessModel.DANKAR) {
            populationUniques = riskModel.getFractionOfUniqueTuplesDankar(false);
        } else {
            populationUniques = riskModel.getFractionOfUniqueTuples(this.statisticalModel);
        }
        if (populationUniques > 0d && populationUniques <= getRiskThreshold()) {
            return true;
        } else if (populationUniques == 0d && distribution.getFractionOfTuplesInClassesOfSize(1) == 0d) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PopulationUniqueness clone() {
        return new PopulationUniqueness(this.getRiskThreshold(),
                                        this.getStatisticalModel(),
                                        this.getPopulationModel(),
                                        this.solverConfig);
    }
}
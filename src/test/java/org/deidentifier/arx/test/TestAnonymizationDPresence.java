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

package org.deidentifier.arx.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.deidentifier.arx.ARXConfiguration;
import org.deidentifier.arx.Data;
import org.deidentifier.arx.DataSubset;
import org.deidentifier.arx.criteria.DPresence;
import org.deidentifier.arx.metric.Metric;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test for data transformations.
 *
 * @author Fabian Prasser
 * @author Florian Kohlmayer
 */
@RunWith(Parameterized.class)
public class TestAnonymizationDPresence extends AbstractAnonymizationTest {
    
    /**
     * 
     *
     * @return
     * @throws IOException
     */
    @Parameters(name = "{index}:[{0}]")
    public static Collection<Object[]> cases() throws IOException {
        return Arrays.asList(new Object[][] {
                                              
                                              /* 0 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 52.0, new int[] { 1, 4, 1, 1, 0, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 30238.2081484441, new int[] { 0, 1, 1, 2, 3, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 30238.2081484441, new int[] { 0, 1, 1, 2, 3, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 8.02127659574468, new int[] { 0, 0, 1, 2, 1, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 19804.2887675027, new int[] { 1, 0, 1, 1, 2, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 20747.362350403302, new int[] { 1, 0, 1, 1, 2, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 150.8, new int[] { 0, 4, 0, 1, 3, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 37223.2491248282, new int[] { 1, 4, 1, 1, 1, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 37223.2491248282, new int[] { 1, 4, 1, 1, 1, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 97.29032258064517, new int[] { 1, 4, 1, 1, 0, 2, 2, 1 }, false) },
                                              /* 10 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 33649.9118226187, new int[] { 1, 4, 1, 1, 0, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 33660.3063277646, new int[] { 1, 4, 1, 1, 0, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 186.58823529411765, new int[] { 5, 1, 1, 1, 1, 3, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 183507.9666833512, new int[] { 5, 1, 1, 1, 1, 3, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 183507.9666833512, new int[] { 5, 1, 1, 1, 1, 3, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 6.375879396984924, new int[] { 4, 0, 1, 1, 1, 3, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 124388.3772460361, new int[] { 3, 2, 1, 1, 0, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 128068.07605943311, new int[] { 2, 4, 1, 1, 0, 3, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 906.2857142857143, new int[] { 5, 4, 1, 0, 1, 4, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 195829.0291224279, new int[] { 5, 4, 1, 0, 1, 4, 4 }, false) },
                                              /* 20 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 195829.0291224279, new int[] { 5, 4, 1, 0, 1, 4, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 333.89473684210526, new int[] { 4, 4, 1, 1, 1, 4, 3 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 188685.11376583832, new int[] { 4, 4, 1, 1, 1, 4, 3 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("cup"), TestData("cup_subset")))), "RAMNTALL", TestFilePath("cup"), 188698.52093140973, new int[] { 4, 4, 1, 1, 1, 4, 3 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 53.402116402116405, new int[] { 3, 2, 3, 0, 1, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 108403.7563334213, new int[] { 3, 2, 3, 0, 1, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 108403.7563334213, new int[] { 3, 2, 3, 0, 1, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 7.229942693409742, new int[] { 0, 2, 2, 3, 0, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 64967.1092445561, new int[] { 1, 0, 3, 1, 0, 0, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 71702.44834529031, new int[] { 1, 0, 3, 1, 0, 0, 0 }, false) },
                                              /* 30 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 152.92424242424244, new int[] { 5, 2, 2, 0, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 142414.2491462392, new int[] { 1, 2, 3, 3, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 142414.2491462392, new int[] { 1, 2, 3, 3, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 63.879746835443036, new int[] { 3, 2, 3, 0, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 130155.7199192575, new int[] { 3, 2, 3, 0, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("fars"), TestData("fars_subset")))), "istatenum", TestFilePath("fars"), 130481.14757714301, new int[] { 3, 2, 3, 0, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 81.70454545454545, new int[] { 0, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 347941.72665935673, new int[] { 0, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 347941.72665935673, new int[] { 0, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 12.388008270158512, new int[] { 0, 0, 0, 1, 1, 2, 2, 1 }, false) },
                                              /* 40 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 117237.8046569406, new int[] { 0, 1, 0, 1, 1, 0, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 159691.67833137378, new int[] { 0, 1, 0, 1, 1, 0, 1, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 162.42469879518072, new int[] { 0, 0, 1, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 400542.9546949434, new int[] { 1, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 400542.9546949434, new int[] { 1, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 82.07762557077625, new int[] { 0, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 347941.72665935673, new int[] { 0, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("atus"), TestData("atus_subset")))), "Highest level of school completed", TestFilePath("atus"), 348509.5903491556, new int[] { 0, 0, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 43.36845930232558, new int[] { 4, 0, 0, 3, 0, 2, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 1158549.7301484977, new int[] { 4, 0, 0, 3, 0, 2, 0, 1 }, false) },
                                              /* 50 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 1158549.7301484977, new int[] { 4, 0, 0, 3, 0, 2, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 6.0464055929885, new int[] { 0, 1, 0, 2, 0, 2, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 713446.6556131733, new int[] { 4, 0, 0, 0, 0, 1, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.0, 0.2, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 799812.4275867802, new int[] { 4, 0, 0, 0, 0, 1, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 86.73691860465117, new int[] { 2, 0, 2, 3, 0, 2, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 1287579.5821546589, new int[] { 0, 0, 0, 3, 4, 1, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 1287579.5821546589, new int[] { 0, 0, 0, 3, 4, 1, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 27.411575562700964, new int[] { 0, 2, 1, 3, 0, 2, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 1073722.7704188202, new int[] { 0, 1, 1, 3, 0, 2, 1, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DPresence(0.05, 0.15, DataSubset.create(TestData("ihis"), TestData("ihis_subset")))), "EDUC", TestFilePath("ihis"), 1091154.322219155, new int[] { 0, 1, 1, 3, 0, 2, 1, 1 }, false) },
                                              
        });
    }
    
    /**
     * 
     *
     * @param testCase
     */
    public TestAnonymizationDPresence(final ARXAnonymizationTestCase testCase) {
        super(testCase);
    }
    
}

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
import org.deidentifier.arx.criteria.KMap;
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
public class TestAnonymizationKMap extends AbstractAnonymizationTest {
    
    /**
     * 
     *
     * @return
     * @throws IOException
     */
    @Parameters(name = "{index}:[{0}]")
    public static Collection<Object[]> cases() throws IOException {
        return Arrays.asList(new Object[][] {
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new KMap(5, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 45.014925373134325, new int[] { 1, 0, 1, 2, 3, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new KMap(3, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 23387.494246375998, new int[] { 0, 0, 1, 2, 3, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new KMap(5, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 28551.7222913157, new int[] { 1, 0, 1, 2, 3, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new KMap(20, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 11.424242424242424, new int[] { 1, 0, 1, 1, 3, 2, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new KMap(7, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 17075.7181747451, new int[] { 0, 0, 1, 1, 2, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new KMap(3, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 15121.633326877098, new int[] { 0, 0, 1, 1, 1, 2, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createAECSMetric()).addCriterion(new KMap(5, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 45.014925373134325, new int[] { 1, 0, 1, 2, 3, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new KMap(2, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 23108.1673304724, new int[] { 1, 0, 1, 1, 3, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new KMap(10, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 30238.2081484441, new int[] { 0, 1, 1, 2, 3, 2, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createAECSMetric()).addCriterion(new KMap(10, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 7.215311004784689, new int[] { 0, 0, 1, 1, 3, 2, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new KMap(5, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 17053.8743069776, new int[] { 0, 0, 1, 0, 2, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.05d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new KMap(3, DataSubset.create(TestData("adult"), TestData("adult_subset")))), "occupation", TestFilePath("adult"), 15121.633326877098, new int[] { 0, 0, 1, 1, 1, 2, 1, 0 }, false) },
                                              
        });
    }
    
    /**
     * 
     *
     * @param testCase
     */
    public TestAnonymizationKMap(final ARXAnonymizationTestCase testCase) {
        super(testCase);
    }
    
}

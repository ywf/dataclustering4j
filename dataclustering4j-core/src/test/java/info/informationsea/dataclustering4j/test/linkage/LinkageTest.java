/**
 *  dataclustering4j
 *  Copyright (C) 2014 Yasunobu OKAMURA
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.informationsea.dataclustering4j.test.linkage;

import info.informationsea.dataclustering4j.clustering.ClusterNode;
import info.informationsea.dataclustering4j.distance.DistanceMatrixMaker;
import info.informationsea.dataclustering4j.distance.DoubleEuclidDistance;
import info.informationsea.dataclustering4j.linkage.CompleteLinkage;
import info.informationsea.dataclustering4j.linkage.Linkage;
import info.informationsea.dataclustering4j.matrix.DefaultMutableMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LinkageTest {
    private DefaultMutableMatrix<Double> original;
    private DistanceMatrixMaker.DistanceMatrix distanceMatrix;

    @Before
    public void setUp() throws IOException {
        original = new DefaultMutableMatrix<Double>(new Double[]{0., 0., 1., 0., 1., 0.5, 1., 3., 1.0, 4.0, 1.5, 3.0}, 2);
        distanceMatrix = new DistanceMatrixMaker<Double>().matrixDistance(original, new DoubleEuclidDistance());
    }

    @Test
    public void testCompleteLinkage() throws IOException {
        Linkage l = new CompleteLinkage();
        Assert.assertEquals(0, l.distance(distanceMatrix, new TestNode(new int[]{0}), new TestNode(new int[]{0})), 0);
        Assert.assertEquals(1, l.distance(distanceMatrix, new TestNode(new int[]{0}), new TestNode(new int[]{1})), 0);
        Assert.assertEquals(Math.sqrt(1+Math.pow(0.5, 2)),
                l.distance(distanceMatrix, new TestNode(new int[]{0}), new TestNode(new int[]{1, 2})), 0);
        Assert.assertEquals(4,
                l.distance(distanceMatrix, new TestNode(new int[]{3,4}), new TestNode(new int[]{1, 2})), 0);
    }

    private static class TestNode implements ClusterNode {
        Set<Integer> m_leafIndexes = new HashSet<Integer>();

        public TestNode(int[] leafIndexes) {
            for (int v: leafIndexes) {
                m_leafIndexes.add(v);
            }
        }

        @Override
        public Set<Integer> leafIndexes() {
            return m_leafIndexes;
        }

        @Override
        public ClusterNode[] getChildren() {
            return new ClusterNode[0];
        }
    }
}
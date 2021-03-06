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

package info.informationsea.dataclustering4j.clustering;

import java.util.List;

/**
 * Represents a result of hierarchical clustering
 */
public interface ClusterNode {
    /**
     * Return all indexes belonged to this node
     * @return all indexes of leaves
     */
    public List<Integer> leafIndexes();

    /**
     * Return direct children of this node
     * @return return children of this node
     */
    public ClusterNode[] getChildren();

    /**
     * Is this node leaf?
     * @return return true if this node is a leaf
     */
    public boolean isLeaf();

    /**
     * Get a distance of child nodes
     * @return a distance of child nodes
     */
    public double distance();
}

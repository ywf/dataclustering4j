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

package info.informationsea.dataclustering4j.matrix.aggregate;

import java.util.Comparator;
import java.util.List;

public class Median implements Aggregate<Number, Double> {
    @Override
    public Double process(List<Number> array) {
        array.sort(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return Double.compare(o1.doubleValue(), o2.doubleValue());
            }
        });

        if (array.size() % 2 == 0) {
            return (array.get(array.size()/2).doubleValue() + array.get(array.size()/2-1).doubleValue())/2;
        } else {
            return array.get(array.size()/2).doubleValue();
        }
    }
}

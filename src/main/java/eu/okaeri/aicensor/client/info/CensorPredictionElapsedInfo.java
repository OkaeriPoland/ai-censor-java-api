/*
 * OK! AI.Censor Java Client
 * Copyright (C) 2019 Okaeri
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package eu.okaeri.aicensor.client.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class CensorPredictionElapsedInfo {

    private final double all;
    private final double processing;

    @JsonCreator
    public CensorPredictionElapsedInfo(@JsonProperty("all") double all, @JsonProperty("processing") double processing) {
        this.all = all;
        this.processing = processing;
    }

    @JsonProperty("all")
    public double getAll() {
        return this.all;
    }

    @JsonProperty("processing")
    public double getProcessing() {
        return this.processing;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CensorPredictionElapsedInfo.class.getSimpleName() + "[", "]")
                .add("all=" + this.all)
                .add("processing=" + this.processing)
                .toString();
    }
}

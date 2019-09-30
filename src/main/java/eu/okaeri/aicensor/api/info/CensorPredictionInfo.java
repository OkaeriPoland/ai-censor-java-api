/*
 * OK! AI.Censor Java API
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
package eu.okaeri.aicensor.api.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import eu.okaeri.aicensor.api.CensorApiContext;
import eu.okaeri.aicensor.api.ApiException;
import eu.okaeri.aicensor.api.ApiResource;

import java.util.*;

public class CensorPredictionInfo {

    private final UUID id;
    private final boolean swear;
    private final String breakdown;
    private final double elapsedAll;
    private final double elapsedProcessing;

    @JsonCreator
    public CensorPredictionInfo(@JsonProperty("id") UUID id,
                                @JsonProperty("swear") boolean swear,
                                @JsonProperty("breakdown") String breakdown,
                                @JsonProperty("elapsed_all") double elapsedAll,
                                @JsonProperty("elapsed_processing") double elapsedProcessing) {
        this.id = id;
        this.swear = swear;
        this.breakdown = breakdown;
        this.elapsedAll = elapsedAll;
        this.elapsedProcessing = elapsedProcessing;
    }

    @JsonProperty("id")
    public UUID getId() {
        return this.id;
    }

    @JsonProperty("swear")
    public boolean isSwear() {
        return this.swear;
    }

    @JsonProperty("breakdown")
    public String getBreakdown() {
        return this.breakdown;
    }

    @JsonProperty("elapsed_all")
    public double getElapsedAll() {
        return this.elapsedAll;
    }

    @JsonProperty("elapsed_processing")
    public double getElapsedProcessing() {
        return this.elapsedProcessing;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CensorPredictionInfo.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("swear=" + this.swear)
                .add("breakdown='" + this.breakdown + "'")
                .add("elapsedAll=" + this.elapsedAll)
                .add("elapsedProcessing=" + this.elapsedProcessing)
                .toString();
    }

    @JsonIgnore
    public static CensorPredictionInfo get(CensorApiContext apiContext, String phrase) throws ApiException {
        return ApiResource.post(apiContext, "/predict", Collections.singletonMap("phrase", phrase), CensorPredictionInfo.class);
    }
}

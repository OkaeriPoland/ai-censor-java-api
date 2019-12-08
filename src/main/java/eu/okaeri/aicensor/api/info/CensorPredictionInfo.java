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
    private final CensorPredictionGeneralInfo general;
    private final CensorPredictionDetailsInfo details;
    private final CensorPredictionElapsedInfo elapsed;

    @JsonCreator
    public CensorPredictionInfo(@JsonProperty("id") UUID id,
                                @JsonProperty("general") CensorPredictionGeneralInfo general,
                                @JsonProperty("details") CensorPredictionDetailsInfo details,
                                @JsonProperty("elapsed") CensorPredictionElapsedInfo elapsed) {
        this.id = id;
        this.general = general;
        this.details = details;
        this.elapsed = elapsed;
    }

    @JsonProperty("id")
    public UUID getId() {
        return this.id;
    }

    @JsonProperty("general")
    public CensorPredictionGeneralInfo getGeneral() {
        return this.general;
    }

    @JsonProperty("details")
    public CensorPredictionDetailsInfo getDetails() {
        return this.details;
    }

    @JsonProperty("elapsed")
    public CensorPredictionElapsedInfo getElapsed() {
        return this.elapsed;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CensorPredictionInfo.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("general=" + this.general)
                .add("details=" + this.details)
                .add("elapsed=" + this.elapsed)
                .toString();
    }

    @JsonIgnore
    public static CensorPredictionInfo get(CensorApiContext apiContext, String phrase) throws ApiException {
        return ApiResource.post(apiContext, "/predict", Collections.singletonMap("phrase", phrase), CensorPredictionInfo.class);
    }
}

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

public class CensorPredictionDetailsInfo {

    private final boolean basicContainsHit;
    private final boolean exactMatchHit;
    private final String aiLabel;
    private final double aiProbability;

    @JsonCreator
    public CensorPredictionDetailsInfo(@JsonProperty("basic_contains_hit") boolean basicContainsHit,
                                       @JsonProperty("exact_match_hit") boolean exactMatchHit,
                                       @JsonProperty("ai_label") String aiLabel,
                                       @JsonProperty("ai_probability") double aiProbability) {
        this.basicContainsHit = basicContainsHit;
        this.exactMatchHit = exactMatchHit;
        this.aiLabel = aiLabel;
        this.aiProbability = aiProbability;
    }

    @JsonProperty("basic_contains_hit")
    public boolean isBasicContainsHit() {
        return this.basicContainsHit;
    }

    @JsonProperty("exact_match_hit")
    public boolean isExactMatchHit() {
        return this.exactMatchHit;
    }

    @JsonProperty("ai_label")
    public String getAiLabel() {
        return this.aiLabel;
    }

    @JsonProperty("ai_probability")
    public double getAiProbability() {
        return this.aiProbability;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CensorPredictionDetailsInfo.class.getSimpleName() + "[", "]")
                .add("basicContainsHit=" + this.basicContainsHit)
                .add("exactMatchHit=" + this.exactMatchHit)
                .add("aiLabel='" + this.aiLabel + "'")
                .add("aiProbability=" + this.aiProbability)
                .toString();
    }
}

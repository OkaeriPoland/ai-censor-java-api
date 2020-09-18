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

public class CensorPredictionGeneralInfo {

    private final boolean swear;
    private final String breakdown;
    private final boolean domains;

    @JsonCreator
    public CensorPredictionGeneralInfo(@JsonProperty("swear") boolean swear,
                                       @JsonProperty("breakdown") String breakdown,
                                       @JsonProperty("domains") boolean domains) {
        this.swear = swear;
        this.breakdown = breakdown;
        this.domains = domains;
    }

    @JsonProperty("swear")
    public boolean isSwear() {
        return this.swear;
    }

    @JsonProperty("breakdown")
    public String getBreakdown() {
        return this.breakdown;
    }

    @JsonProperty("domains")
    public boolean hasDomains() {
        return this.domains;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CensorPredictionGeneralInfo.class.getSimpleName() + "[", "]")
                .add("swear=" + this.swear)
                .add("breakdown='" + this.breakdown + "'")
                .add("domains=" + this.domains)
                .toString();
    }
}

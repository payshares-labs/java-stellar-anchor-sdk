package org.stellar.anchor.dto.sep12;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Optional;

public enum Sep12Status {
  @SerializedName("ACCEPTED")
  ACCEPTED("ACCEPTED"),

  @SerializedName("PROCESSING")
  PROCESSING("PROCESSING"),

  @SerializedName("REJECTED")
  REJECTED("REJECTED"),

  @SerializedName("VERIFICATION_REQUIRED")
  VERIFICATION_REQUIRED("VERIFICATION_REQUIRED");

  private final String name;

  Sep12Status(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public static Optional<Sep12Status> byName(String match) {
    return Arrays.stream(values()).filter(it -> it.name.equalsIgnoreCase(match)).findFirst();
  }
}
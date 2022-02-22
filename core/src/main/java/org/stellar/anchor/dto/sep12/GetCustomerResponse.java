package org.stellar.anchor.dto.sep12;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;

/**
 * Refer to SEP-12.
 *
 * https://github.com/stellar/stellar-protocol/blob/master/ecosystem/sep-0012.md#response
 */
@Data
public class GetCustomerResponse {
  String id;
  Sep12Status status;

  Map<String, Field> fields;

  @SerializedName("provided_fields")
  Map<String, ProvidedField> providedFields;

  String message;
}

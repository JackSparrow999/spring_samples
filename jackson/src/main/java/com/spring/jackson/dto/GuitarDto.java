package com.spring.jackson.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.spring.jackson.enumeration.Genre;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
//the fields in ignore properties are neither accepted nor sent in request or response
@JsonIgnoreProperties({"serialId", "productId"})
//orders the response fields
@JsonPropertyOrder({"id", "brand", "name"})
//Since we don't pass anything in customerName it should be null in response
//This annotation removes all null fields in the json response
@JsonInclude(value = Include.NON_EMPTY)
public class GuitarDto {
	 
	//helps map the json field name to the model field name
	@JsonProperty(value = "guitar_id")
	private Long id;
	private String name;
	private String brand;
	//the json can read this field only i.e. request value won't be written into the object field
	@JsonProperty(access = Access.READ_ONLY)
	private Long price;
	//write_only writes the json value in field value i.e. does not allow field in response
	@JsonProperty(value = "want_to_buy", access = Access.WRITE_ONLY)
	private boolean wantToBuy;
	private Long serialId;
	private Long productId;
	//accepts the raw json value in the request and deserializes it 
	@JsonRawValue
	private String motto;
	private String customerName;
	
	//@JsonValue in the enum method allows the enum value to be accepted
	//Otherwise only the type is accepted
	private Genre genre;
	
	//deactivates the lombok getter, setter for this particular field
	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	private boolean isRegular;
	
	//makes Jackson use this setter for deserialization
	@JsonSetter
	public void setIsRegular(boolean isRegular) {
		this.isRegular = isRegular;
	}
	
	//makes Jackson use this getter for serialization
	@JsonGetter
	public boolean getIsRegular() {
		return this.isRegular;
	}
}

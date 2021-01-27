package com.asknhcrn.elasticsearch.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Document(indexName = "products") // elastic search = docementBase
@Data // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class Product {

	@Id
	private String id;
	
	@Field(name = "name", type = FieldType.Text)
	private String name;

	@Field(name = "description", type = FieldType.Text)
	private String description;

	@Field(name = "createdDate", type = FieldType.Date)
	private Date createdDate;

}

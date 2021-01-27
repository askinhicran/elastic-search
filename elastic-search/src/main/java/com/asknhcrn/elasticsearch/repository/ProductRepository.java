package com.asknhcrn.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.asknhcrn.elasticsearch.entity.Product;

@Repository // bunu yazmasakta tanıyor artık yeni versiyonla
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

	
//	  @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
//	  List<User> getByCustomQuery(String search); // search edilen text i elastic search ün kendi query mantıgı ile arayacak.Ben name parametresi ile ara dedim.

	  List<Product>  findByNameLikeOrDescriptionLike(String ad, String desc); // dısarıdan search edilen text i ad a ya da description a gore ara dedim. localhost:8080/iphone gibi
}

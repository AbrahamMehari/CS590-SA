package com.ascs.RestClient;

import com.ascs.RestClient.domain.ProductDto;
import com.ascs.RestClient.domain.Products;
import com.ascs.RestClient.domain.ReviewDto;
import com.ascs.RestClient.domain.StockDto;
import com.ascs.RestClient.domain.shoppingCart.CartLineDto;
import com.ascs.RestClient.domain.shoppingCart.ProductShoppingCartDto;
import com.ascs.RestClient.domain.shoppingCart.ShoppingCartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {


	RestTemplate template = new RestTemplate();
	String url = "http://localhost:8080/product";
	String urlShopping = "http://localhost:8081/shoppingcart";



//	@Bean
//	RestTemplate restTemplate (){
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ReviewDto r1 = new ReviewDto("review1","description",9);
		ReviewDto r2 = new ReviewDto("review2","description",45);

		StockDto s1 = new StockDto(12,12);

		ProductDto product = new ProductDto(123,"apple","apple phone",456,12,s1);
		product.addReview(r1);
		product.addReview(r2);
// Add new product to the product component
		template.postForLocation(url,product);

//		Get the product from the product component and print to the console
		System.out.println("product form product table");
		Products readdata =  template.getForObject(url, Products.class);

		assert readdata != null;
		readdata.getProductDtos().forEach(System.out::println);
//		Add this product to the shopping cart
		System.out.println("add to shopping cart");
		ShoppingCartDto shoppingCartDto = new ShoppingCartDto(123);

		ProductShoppingCartDto productShoppingCartDto = new ProductShoppingCartDto(product.getProductNumber(),
				product.getName(),product.getPrice());
		CartLineDto pro1 = new CartLineDto(1,product.getProductNumber(),productShoppingCartDto);

		shoppingCartDto.addCartLine(pro1);

		System.out.println(shoppingCartDto);
//		template.postForLocation(urlShopping,shoppingCartDto);



	}
}

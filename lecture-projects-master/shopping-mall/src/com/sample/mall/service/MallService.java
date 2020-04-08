package com.sample.mall.service;

import com.sample.mall.repository.OrderRepository;
import com.sample.mall.repository.ProductRepository;
import com.sample.mall.repository.UserRepository;
import com.sample.mall.vo.Item;
import com.sample.mall.vo.Order;
import com.sample.mall.vo.Product;
import com.sample.mall.vo.User;

public class MallService {

	private OrderRepository orderRepo = new OrderRepository();
	private ProductRepository productRepo = new ProductRepository();
	private UserRepository userRepo = new UserRepository();
	
	/**
	 * 모든 상품정보를 화면에 표시한다.<br/>
	 * 출력내용 :: 상품번호, 상품명, 가격, 할인가격 정보를 표시한다.<br /><br />
	 * 
	 * ProductRepository의 모든 상품정보 조회기능을 실행해서 상품정보 배열(Product가 저장된 배열)을 제공받아서 표시한다.
	 */
	public void displayAllProducts() {
		Product[] product = productRepo.getAllProducts();
		System.out.println("상품번호\t상품명\t가격\t할인가격");
		int count = 0;
		
		for(int i=0; i<product.length;i++) {
			if(product[i] == null) {
				return;
			}
			System.out.print(product[i].no+"\t");
			System.out.print(product[i].name+"\t");
			System.out.print(product[i].price+"\t");
			System.out.println(product[i].discountPrice+"\t");
		}
	}
	
	/**
	 * 상품번호를 전달받아서 그 상품번호에 해당하는 상품의 상세정보를 화면에 표시한다.<br/>
	 * 출력내용 :: 상품번호, 상품명, 가격, 할인가격, 재고, 판매지수 정보를 표시한다.<br /><br />
	 * 
	 * ProductRepository의 상품상세정보 조회 기능에 상품번호를 전달해서 상품정보(Product객체)를 제공받아서 표시한다.
	 * @param productNo 상세정보를 조회할 상품번호
	 */
	public void displayProductDetail(int productNo) {
		System.out.println("상품번호\t상품명\t가격\t할인가격\t재고\t판매지수");
		Product product = productRepo.getProductByNo(productNo);
		if(product == null) {
			System.out.println("상품번호를 정확히 입력해주세요");
		} else {
			System.out.print(product.no+"\t");
			System.out.print(product.name+"\t");
			System.out.print(product.price+"\t");
			System.out.print(product.discountPrice+"\t");
			System.out.print(product.stock+"\t");
			System.out.println(product.score);
		}
		
		
	}
	
	/**
	 * 사용자 아이디와 상품번호를 전달받아서 해당 사용자의 장바구니에 상품정보를 저장한다.<br/>
	 * 사용자의 장바구니에 동일한 상품이 존재하는 경우는 장바구니에 추가되지 않는다.<br/>
	 * 상품의 재고가 0개인 경우는 장바구니에 추가되지 않는다.<br /><br />
	 * 
	 * UserRepository의 사용자정보 조회 기능에 사용자 아이디를 전달해서 사용자정보(User객체)를 제공받는다.<br/>
	 * Item객체를 생성해서 상품번호, 상품명, 구매가격을 저장한다.<br/>
	 * User객체의 장바구니 아이템 추가 기능에 생성된 Item을 전달해서 장바구니에 추가한다.<br/>
	 * ProductRepository의 상품상제정보 조회기능을 실행해서 상품정보(Product객체)를 제공받는다.
	 * 상품의 재고를 1감소시킨다.
	 * @param userId 사용자 아이디
	 * @param productNo 장바구니에 추가할 상품번호
	 */
	public void addCartItem(String userId, int productNo) {
		User findUser = userRepo.getUserById(userId);
		if (findUser == null) {
			System.out.println("회원정보가 없습니다.");
			return;
		}
		Product product = productRepo.getProductByNo(productNo);
		if (product == null) {
			System.out.println("상품정보가 없습니다.");
			return;
		}
		Item item = new Item();
		item.name = product.name;
		item.orderPrice = product.price;
		
		findUser.addItem(item);
		
		product.stock -= 1;
		
	}
	
	/**
	 * 사용자 아이디를 전달받아서 그 사용자의 장바구니에 저장된 모든 상품정보를 화면에 출력한다.<br />
	 * 표시내용 :: 아이템번호, 상품번호, 상품명, 구매가격 정보를 표시한다.<br /><br />
	 * 
	 * UserRepository의 사용자정보 조회 기능에 사용자 아이디를 전달해서 사용자정보(User객체)를 제공받는다.<br />
	 * User객체의 장바구니 아이템조회기능을 사용해서 모든 Item정보를 제공받고 화면에 출력한다.
	 * @param userId 장바구니에 저장될 상품 정보를 조회할 사용자 아이디
	 */
	public void displayMyCart(String userId) {
		
		System.out.println("아이템번호\t상품번호\t상품명\t구매가격");
		Product product = null;
		User user = userRepo.getUserById(userId);
		Item[] userItem = user.getItems();	
		for(int i=0; i<userItem.length; i++) {
			product = productRepo.getProductByName(userItem[i].name);
		}
		for(int i=0; i<userItem.length;i++) {
			System.out.print(userItem[i].no+"\t");
			System.out.print(product.no+"\t");
			System.out.print(product.name+"\t");
			System.out.println(product.price-product.discountPrice);
		}
		
	}
	
	
	/**
	 * 사용자 아이디를 전달받아서 그 사용자의 장바구니에 저장된 모든 상품을 주문한다.<br /><br />
	 * 
	 * UserRepository의 사용자정보 조회 기능에 사용자 아이디를 전달해서 사용자정보(User객체)를 제공받는다.<br />
	 * <ol>
	 * <li>Order객체를 생성하고, 사용자 아이디를 저장한다.</li>
	 * <li>위에서 조회된 User객체의 장바구니에서 Item객체를 하나씩 꺼낸다.
	 * 	<ol>
	 * 		<li>Item객체에서 구매가격를 꺼낸다.</li>
	 * 		<li>구매가격의 1%만큼 포인트를 위에서 조회한 User객체의 포인트에 적립한다.</li>
	 * 		<li>Item객체를 Order객체의 items배열에 저장한다.</li>
	 * 	</ol>
	 * </li>
	 * <li>위에서 생성한 Order객체를 OrderRepository의 주문저장기능에 전달해서 저장되게 한다.</li>
	 * <li>User객체의 장바구니 비우기 기능을 실행한다.</li>
	 * </ol>
	 * @param userId 장바구니에 저장된 모든 상품정보를 주문하고 싶어하는 사용자 아이디
	 */
	public void cartToOrder(String userId) {
		
		User findUser = userRepo.getUserById(userId);
		Order order = new Order();
		order.userId = userId;
		Item[] findUserItem = findUser.getItems();
		for(int i=0; i<findUserItem.length; i++) {
			int findProductPrice = findUserItem[i].orderPrice;
			findUser.point = (int)(findProductPrice * 0.01);
			order.addItem(findUserItem[i]);
		}
		orderRepo.insertOrder(order);
		findUser.clearItems();
		
	}
	
	/**
	 * 사용자 아이디를 전달받아서 그 사용자의 모든 주문내역을 화면에 출력한다.<br/><br/>
	 * 
	 * OrderRepository의 주문내역조회 기능에 사용자 아이디를 전달해서 그 사용자의 모든 주문정보(Order배열)를 제공받아서 출력한다.
	 * @param userId
	 */
	public void displayMyOrders(String userId) {
		
		Order[] order = orderRepo.getOrderByUserId(userId);
		for(int i=0; i < order.length; i++) {
			Item[] item = order[i].getItems();
			for(int j=0; j<item.length;j++) {
				System.out.print("상품명\t구매가격");
				System.out.println(item[j].name);
				System.out.println(item[j].orderPrice);
			}
		}
		
		
	}
}

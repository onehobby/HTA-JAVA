package oop1;

public class TvDemo {

	public static void main(String[] args) {
		
		Tv tv = new Tv();
		tv.power();
		tv.channelDown();
		tv.channelUp();
		
		CaptionTv captionTv = new CaptionTv();

		captionTv.caption = true;
		captionTv.displayCaption("시각장애우를 위한 자막을 표시합니다.");
		
		IPTv ipTv = new IPTv();
		ipTv.power();					// tv클래스에 정의되어 있는 속성 및 기능사용
		ipTv.channelDown();				// tv클래스에 정의되어 있는 속성 및 기능사용
		ipTv.channelUp();				// tv클래스에 정의되어 있는 속성 및 기능사용
		ipTv.ip = "143.56.78.123";		// IpTv에 정의되어 있는 속성 및 기능 사용
		ipTv.internet("www.daum.net");	// IpTv에 정의되어 있는 속성 및 기능 사용
		
		NetflixTv netflixTv = new NetflixTv();
		netflixTv.power();					// tv클래스에 정의되어 있는 속성 및 기능사용
		netflixTv.channelUp();				// tv클래스에 정의되어 있는 속성 및 기능사용
		netflixTv.channelDown();			// tv클래스에 정의되어 있는 속성 및 기능사용
		netflixTv.internet("www.daum.net");	// IpTv에 정의되어 있는 속성 및 기능 사용
		netflixTv.ip = "211.167.24.123";	// IpTv에 정의되어 있는 속성 및 기능 사용
		netflixTv.membership = "standard";	// NetflixTv에 정의되어있는 속성 및 기능 사용
		netflixTv.watchMovie("더블타겟");		// NetflixTv에 정의되어있는 기능 및 기능 사용
		
	}
	
	
	
	
}

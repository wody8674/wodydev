package hts.gis.poi;


/* 상세정보 유무 정보를 얻는다.
*@param index DETAIL_BUSINESS : 영업안내
*DETAIL_RESERVE : 예약
*DETAIL_FACILITY : 부대시설
*DETAIL_PARKING : 주차장
*DETAIL_GOODS : 상품 및 메뉴
*DETAIL_HOTEL : 호텔
*DETAIL_MEMBER : 회원제
*DETAIL_HOSPITAL : 병원
*DETAIL_GOLF : 골프장
*DETAIL_SKI : 스키장
*DETAIL_CP : 자료제공자
*DETAIL_FOOD : 음식점
*DETAIL_HOTEL_PRICE : 호텔가격
*DETAIL_MOVIE : 동영상 정보
*DETAIL_TOUR : 여행지
*@return true:존재함, false:없슴
*/

/** 
 * POI상세정보 
 * @author  JunHwa Park
 * */
public class POIDetailInfo extends POIDEntryBase {
	/** POI 상세 정보 -- 영업안내 */
	public static final int DETAIL_BUSINESS =  0;
	/** POI 상세 정보 -- 예약  */
	public static final int DETAIL_RESERVE	=  1;
	/** POI 상세 정보 -- 부대시설 */
	public static final int DETAIL_FACILITY	=  2;
	/** POI 상세 정보 -- 주차장 */
	public static final int DETAIL_PARKING	=  3;
	/** POI 상세 정보 -- 상품 및 메뉴 */
	public static final int DETAIL_GOODS	=  4;
	/** POI 상세 정보 -- 호텔 */
	public static final int DETAIL_HOTELDETAIL_HOTEL	=  5;
	/** POI 상세 정보 -- 회원제 */
	public static final int DETAIL_MEMBER	=  6;
	/** POI 상세 정보 -- 병원 */
	public static final int DETAIL_HOSPITAL	=  7;
	/** POI 상세 정보 -- 골프장 */
	public static final int DETAIL_GOLF	=  8;
	/** POI 상세 정보 -- 스키장 */
	public static final int DETAIL_SKI	=  9;

	/** 
	 * 상세 정보 갯수 
	 * */
	public static final int MAX_DETAIL_INFO = 10;

	//분류코드
	protected String classCode;
	//분류명
	protected String className;
	//행정코드
	protected String govCode;
	//행정명
	protected String govName;
	//우편번호
	protected String zipCode;
	//주소
	protected String address;
	//기타주소
	protected String etcAddress;
	//찾아가는 길
	protected String road;
	// 해당층수
	protected String floor;

	// 전화번호
	protected String telNo;
	// 확장전화번호
	protected String telNoTo;
	//사업자등록번호
	protected String businessNo;
	//도엽번호
	protected long   meshCode;

	// POI등급 
	protected String grade;
	// 종류
	protected String kind;
	// 중심좌표(x)
	protected double dispX;
	// 중심좌표(y)
	protected double dispY;
	// 안내좌표(x)
	protected double guideX;
	// 안내좌표(y)
	protected double guideY;
	// 상세정보유무 Flag
	protected boolean[] haveDetailInfo;
	// 팬션 아이디
	protected String ps_id;
	

	
	// 드라이브가이드
	protected String   driveGuideKind;
	// POI정식명칭
	protected String name;
	
	
	protected String BusinessDesc;
	

	
	// 건물층수
	protected int bldg_floor;
	// 건물명
	protected String bldg_name;	 
	//상황별코드
	protected String airs_cd;
	
	// 2012.07.19 Jeong Jae Yo 새주소 추가
	//새주소
	protected String newAddress;
	//기타 새주소
	protected String etcNewAddress;
	
	/** POI 상세 정보 -- CP 정보*/	
	public static final int DETAIL_CP	=  14;
	/** POI 상세 정보 -- 음식점 */
	public static final int DETAIL_FOOD	=  10;
	/** POI 상세 정보 -- 호텔가격정보 */
	public static final int DETAIL_HOTEL_PRICE	=  12;
	/** POI 상세 정보 -- 동영상 정보*/
	public static final int DETAIL_MOVIE	=  13;
	/** POI 상세 정보 -- 여행지 */
	public static final int DETAIL_TOUR	=  11;
	/** 상세 정보 갯수(추천관련) */
	public static final int MAX_DETAIL_INFO_R = 15;

	/** 
	 * 생성자
	 * @param id POIID
	 * @param classCode 분류코드
	 * @param className 분류명
	 * @param govCode 행정코드
	 * @param govName 행정명
	 * @param zipCode 우편번호
	 * @param name POI정식명칭
	 * @param address 주소
	 * @param etcAddress 기타주소
	 * @param road 찾아가는 길
	 * @param floor 해당층수
	 * @param telNo 전화번호
	 * @param telNoTo 확장전화번호
	 * @param businessNo 사업자등록번호
	 * @param meshCode 도엽번호
	 * @param grade POI등급 
 	 * @param kind 종류
 	 * @param dispX 중심좌표(x)
 	 * @param dispY 중심좌표(y)
 	 * @param guideX 안내좌표(x)
	 * @param guideY 안내좌표(y)
	 * @param driveGuideKind 드라이브가이드
	 * @param bldg_floor 건물층수
	 * @param bldg_name 건물명
	 * @param haveDetailInfo 상세정보유무 Flag
	 */
	public POIDetailInfo( int id,
		String classCode,
		String className,
		String govCode,
		String govName,
		String zipCode,
		
		String name,
		String address,
		String etcAddress,
		String road,
		String floor,
		
		String telNo,
		String telNoTo,
		String  businessNo,
		long meshCode,
		
		String grade,
		String kind,
		double dispX,
		double dispY,
		
		double guideX,
		double guideY,
		String  driveGuideKind,
		String bldg_name,
		int bldg_floor,
		
		boolean[] haveDetailInfo )
	{
		super( id );
		this.classCode      =   classCode;
		this.className      =   className;
		this.govCode        =   govCode;
		this.govName        =   govName;
		this.zipCode        =   zipCode;
		this.name			=   name;
		this.address        =   address;
		this.etcAddress     =   etcAddress;
		this.road           =   road;
		this.floor          =   floor;
		this.telNo          =   telNo;
		this.telNoTo        =   telNoTo;
		this.businessNo     =   businessNo;
		this.meshCode       =   meshCode;
		this.grade          =   grade;
		this.kind           =   kind;
		this.dispX          =   dispX;
		this.dispY          =   dispY;
		this.guideX         =   guideX;
		this.guideY         =   guideY;
		this.driveGuideKind = driveGuideKind;
		this.bldg_name 		= bldg_name;
		this.bldg_floor 	= bldg_floor;
		//this.airs_cd		= airs_cd;
		this.haveDetailInfo =   new boolean[ haveDetailInfo.length ];
		System.arraycopy( haveDetailInfo, 0, this.haveDetailInfo, 0, haveDetailInfo.length );
	}

	/** 
	 * 생성자
	 * @param id POIID
	 * @param classCode 분류코드
	 * @param className 분류명
	 * @param govCode 행정코드
	 * @param govName 행정명
	 * @param zipCode 우편번호
	 * @param name POI정식명칭
	 * @param address 주소
	 * @param etcAddress 기타주소
	 * @param road 찾아가는 길
	 * @param floor 해당층수
	 * @param telNo 전화번호
	 * @param telNoTo 확장전화번호
	 * @param businessNo 사업자등록번호
	 * @param meshCode 도엽번호
	 * @param grade POI등급 
	 * @param kind 종류
	 * @param dispX 중심좌표(x)
	 * @param dispY 중심좌표(y)
	 * @param guideX 안내좌표(x)
	 * @param guideY 안내좌표(y)
	 * @param driveGuideKind 드라이브가이드
	 * @param bldg_floor 건물층수
	 * @param bldg_name 건물명
	 * @param airs_cd 상황별코드
	 * @param haveDetailInfo 상세정보유무 Flag
	 * @param ps_id 팬션아이디
	 */
	public POIDetailInfo( int id,
		String classCode,
		String className,
		String govCode,
		String govName,
		String zipCode,
		
		String name,
		String address,
		String etcAddress,
		String road,
		String floor,
		
		String telNo,
		String telNoTo,
		String  businessNo,
		long meshCode,
		
		String grade,
		String kind,
		double dispX,
		double dispY,
		
		double guideX,
		double guideY,
		String  driveGuideKind,
		String bldg_name,
		int bldg_floor,
		String airs_cd,
		
		
		boolean[] haveDetailInfo,
		String ps_id) {

		super( id );
		this.classCode      =   classCode;
		this.className      =   className;
		this.govCode        =   govCode;
		this.govName        =   govName;
		this.zipCode        =   zipCode;
		this.name			=   name;
		this.address        =   address;
		this.etcAddress     =   etcAddress;
		this.road           =   road;
		this.floor          =   floor;
		this.telNo          =   telNo;
		this.telNoTo        =   telNoTo;
		this.businessNo     =   businessNo;
		this.meshCode       =   meshCode;
		this.grade          =   grade;
		this.kind           =   kind;
		this.dispX          =   dispX;
		this.dispY          =   dispY;
		this.guideX         =   guideX;
		this.guideY         =   guideY;
		this.driveGuideKind = driveGuideKind;
		this.bldg_name 		= bldg_name;
		this.bldg_floor 	= bldg_floor;
		this.airs_cd		= airs_cd;
		this.haveDetailInfo =   new boolean[ haveDetailInfo.length ];
		this.ps_id		    = ps_id;
		System.arraycopy( haveDetailInfo, 0, this.haveDetailInfo, 0, haveDetailInfo.length );
	}
	
	/** 
	 * 생성자
	 * @param id POIID
	 * @param classCode 분류코드
	 * @param className 분류명
	 * @param govCode 행정코드
	 * @param govName 행정명
	 * @param zipCode 우편번호
	 * @param name POI정식명칭
	 * @param address 주소
	 * @param etcAddress 기타주소
	 * @param road 찾아가는 길
	 * @param floor 해당층수
	 * @param telNo 전화번호
	 * @param telNoTo 확장전화번호
	 * @param businessNo 사업자등록번호
	 * @param meshCode 도엽번호
	 * @param grade POI등급 
	 * @param kind 종류
	 * @param dispX 중심좌표(x)
	 * @param dispY 중심좌표(y)
	 * @param guideX 안내좌표(x)
	 * @param guideY 안내좌표(y)
	 * @param driveGuideKind 드라이브가이드
	 * @param bldg_floor 건물층수
	 * @param bldg_name 건물명
	 * @param airs_cd 상황별코드
	 * @param haveDetailInfo 상세정보유무 Flag
	 */
	public POIDetailInfo( int id,
		String classCode,
		String className,
		String govCode,
		String govName,
		String zipCode,
		
		String name,
		String address,
		String etcAddress,
		String road,
		String floor,
		
		String telNo,
		String telNoTo,
		String  businessNo,
		long meshCode,
		
		String grade,
		String kind,
		double dispX,
		double dispY,
		
		double guideX,
		double guideY,
		String  driveGuideKind,
		String bldg_name,
		int bldg_floor,
		String airs_cd,
		
		
		boolean[] haveDetailInfo) {

		super( id );
		this.classCode      =   classCode;
		this.className      =   className;
		this.govCode        =   govCode;
		this.govName        =   govName;
		this.zipCode        =   zipCode;
		this.name			=   name;
		this.address        =   address;
		this.etcAddress     =   etcAddress;
		this.road           =   road;
		this.floor          =   floor;
		this.telNo          =   telNo;
		this.telNoTo        =   telNoTo;
		this.businessNo     =   businessNo;
		this.meshCode       =   meshCode;
		this.grade          =   grade;
		this.kind           =   kind;
		this.dispX          =   dispX;
		this.dispY          =   dispY;
		this.guideX         =   guideX;
		this.guideY         =   guideY;
		this.driveGuideKind = driveGuideKind;
		this.bldg_name 		= bldg_name;
		this.bldg_floor 	= bldg_floor;
		this.airs_cd		= airs_cd;
		this.haveDetailInfo =   new boolean[ haveDetailInfo.length ];
		//this.poi_reservation_yn = poi_reservation_yn;
		//this.ps_id		    = ps_id;
		System.arraycopy( haveDetailInfo, 0, this.haveDetailInfo, 0, haveDetailInfo.length );
	}
	
	/** 
	 * 생성자
	 * @param id POIID
	 * @param classCode 분류코드
	 * @param className 분류명
	 * @param govCode 행정코드
	 * @param govName 행정명
	 * @param name POI정식명칭
	 * @param address 주소
	 * @param etcAddress 기타주소
	 * @param telNo 전화번호
	 * @param telNoTo 확장전화번호
	 * @param dispX 중심좌표(x)
	 * @param dispY 중심좌표(y)
	 * 2009.12.16 유승현 추가
	 *
	 */
	public POIDetailInfo( 
			int id,
			String classCode,
			String className,
			String govCode,
			String govName,
			
			String name,
			String address,
			String etcAddress,
			
			String telNo,
			String telNoTo,
			
			double dispX,
			double dispY) {
		super(id);
		this.classCode      =   classCode;
		this.className      =   className;
		this.govCode        =   govCode;
		this.govName        =   govName;
		this.name			=   name;
		this.address        =   address;
		this.etcAddress     =   etcAddress;
		this.telNo          =   telNo;
		this.telNoTo        =   telNoTo;
		this.dispX          =   dispX;
		this.dispY          =   dispY;
				
	}

	/** 
	 * 생성자
	 * @param id POIID
	 * @param classCode 분류코드
	 * @param className 분류명
	 * @param govCode 행정코드
	 * @param govName 행정명
	 * @param zipCode 우편번호
	 * @param name POI정식명칭
	 * @param address 주소
	 * @param etcAddress 기타주소
	 * @param road 찾아가는 길
	 * @param floor 해당층수
	 * @param telNo 전화번호
	 * @param telNoTo 확장전화번호
	 * @param businessNo 사업자등록번호
	 * @param meshCode 도엽번호
	 * @param grade POI등급 
	 * @param kind 종류
	 * @param dispX 중심좌표(x)
	 * @param dispY 중심좌표(y)
	 * @param guideX 안내좌표(x)
	 * @param guideY 안내좌표(y)
	 * @param driveGuideKind 드라이브가이드
	 * @param bldg_floor 건물층수
	 * @param bldg_name 건물명
	 * @param airs_cd 상황별코드
	 * @param newAddress 새주소
	 * @param etcNewAddress 새주소건물번호
	 * @param haveDetailInfo 상세정보유무 Flag
	 */
	public POIDetailInfo( int id,
		String classCode,
		String className,
		String govCode,
		String govName,
		String zipCode,
		
		String name,
		String address,
		String etcAddress,
		String road,
		String floor,
		
		String telNo,
		String telNoTo,
		String  businessNo,
		long meshCode,
		
		String grade,
		String kind,
		double dispX,
		double dispY,
		
		double guideX,
		double guideY,
		String  driveGuideKind,
		String bldg_name,
		int bldg_floor,
		String airs_cd,
		
		String newAddress, 
		String etcNewAddress,
		
		boolean[] haveDetailInfo) {

		super( id );
		this.classCode      =   classCode;
		this.className      =   className;
		this.govCode        =   govCode;
		this.govName        =   govName;
		this.zipCode        =   zipCode;
		this.name			=   name;
		this.address        =   address;
		this.etcAddress     =   etcAddress;
		this.road           =   road;
		this.floor          =   floor;
		this.telNo          =   telNo;
		this.telNoTo        =   telNoTo;
		this.businessNo     =   businessNo;
		this.meshCode       =   meshCode;
		this.grade          =   grade;
		this.kind           =   kind;
		this.dispX          =   dispX;
		this.dispY          =   dispY;
		this.guideX         =   guideX;
		this.guideY         =   guideY;
		this.driveGuideKind = driveGuideKind;
		this.bldg_name 		= bldg_name;
		this.bldg_floor 	= bldg_floor;
		this.airs_cd		= airs_cd;
		this.newAddress		= newAddress;
		this.etcNewAddress	= etcNewAddress;
		this.haveDetailInfo =   new boolean[ haveDetailInfo.length ];
		
		System.arraycopy( haveDetailInfo, 0, this.haveDetailInfo, 0, haveDetailInfo.length );
	}
	
	/** 
	 * 생성자
	 * @param id POIID
	 * @param classCode 분류코드
	 * @param className 분류명
	 * @param govCode 행정코드
	 * @param govName 행정명
	 * @param zipCode 우편번호
	 * @param name POI정식명칭
	 * @param address 주소
	 * @param etcAddress 기타주소
	 * @param road 찾아가는 길
	 * @param floor 해당층수
	 * @param telNo 전화번호
	 * @param telNoTo 확장전화번호
	 * @param businessNo 사업자등록번호
	 * @param meshCode 도엽번호
	 * @param grade POI등급 
 	 * @param kind 종류
 	 * @param dispX 중심좌표(x)
 	 * @param dispY 중심좌표(y)
 	 * @param guideX 안내좌표(x)
	 * @param guideY 안내좌표(y)
	 * @param driveGuideKind 드라이브가이드
	 * @param bldg_floor 건물층수
	 * @param bldg_name 건물명
	 * @param newAddress 새주소
	 * @param etcNewAddress 기타새주소
	 * @param haveDetailInfo 상세정보유무 Flag
	 */
	public POIDetailInfo( int id,
		String classCode,
		String className,
		String govCode,
		String govName,
		String zipCode,
		
		String name,
		String address,
		String etcAddress,
		String road,
		String floor,
		
		String telNo,
		String telNoTo,
		String  businessNo,
		long meshCode,
		
		String grade,
		String kind,
		double dispX,
		double dispY,
		
		double guideX,
		double guideY,
		String  driveGuideKind,
		String bldg_name,
		int bldg_floor,
		
		String newAddress,
		String etcNewAddress,
		
		boolean[] haveDetailInfo
		)
	{
		super( id );
		this.classCode      =   classCode;
		this.className      =   className;
		this.govCode        =   govCode;
		this.govName        =   govName;
		this.zipCode        =   zipCode;
		this.name			=   name;
		this.address        =   address;
		this.etcAddress     =   etcAddress;
		this.road           =   road;
		this.floor          =   floor;
		this.telNo          =   telNo;
		this.telNoTo        =   telNoTo;
		this.businessNo     =   businessNo;
		this.meshCode       =   meshCode;
		this.grade          =   grade;
		this.kind           =   kind;
		this.dispX          =   dispX;
		this.dispY          =   dispY;
		this.guideX         =   guideX;
		this.guideY         =   guideY;
		this.driveGuideKind = driveGuideKind;
		this.bldg_name 		= bldg_name;
		this.bldg_floor 	= bldg_floor;
		//this.airs_cd		= airs_cd;
		this.newAddress		= newAddress;
		this.etcNewAddress	= etcNewAddress;
		this.haveDetailInfo =   new boolean[ haveDetailInfo.length ];
		System.arraycopy( haveDetailInfo, 0, this.haveDetailInfo, 0, haveDetailInfo.length );
	}
	
	
	/** 
	 * 주소 얻기
	*@return 주소
	*/
	public String getAddress() { return this.address; }

	/** 
	 * 상황별코드 얻기
	*@return 상황별코드
	*/
	public String getAirsCd() {
		return this.airs_cd;
	}

	/** 
	 * 건물층수를 얻는다 
	*@return Bldg_floor
	*/
	public int getBldgFloor() { return this.bldg_floor; }

	/** 
	 * BldgName를 얻는다 
	*@return BldgName
	*/
	public String getBldgName() { return this.bldg_name; }

	/** 
	 * 사업자 등록번호를 얻는다
	*@return 사업자 등록번호
	*/
	public String getBusinessNo() { return this.businessNo; }

	/** 
	 * 분류 코드 얻기
	*@return 분류코드 
	*/
	public String getClassCode() { return this.classCode; }

	/** 
	 * 분류 명 얻기
	*@return 분류명 
	*/
	public String getClassName() { return this.className; }

	/** 
	 * 중심 경도를 얻는다
	*@return 중심 경도
	*/
	public double getDisplayX() { return this.dispX; }

	/** 
	 * 중심 위도를 얻는다
	*@return 중심 위도
	*/
	public double getDisplayY() { return this.dispY; }

	/** 
	 * 드라이브 가이드 종류를 얻는다
	*@return 드라이브 가이드 종류
	*/
	public String getDriveGuideKind() { return this.driveGuideKind; }

	/** 
	 * 상세 주소 얻기
	*@return 상세 주소 
	*/
	public String getEtcAddress() { return this.etcAddress; }

	/** 
	 * 건물에 위치한 층수
	*@return 층수
	*/
	public String getFloor() { return this.floor; }

	/** 
	 * 행정 코드 얻기
	*@return 행정코드 
	*/
	public String getGovCode() { return this.govCode; }

	/** 
	 * 행정명 얻기
	*@return 행정명 
	*/
	public String getGovName() { return this.govName; }

	/** 
	 * 등급을 얻는다
	*@return POI 등급 
	*/
	public String getGrade() { return this.grade; }

	/** 
	 * 안내 경도를 얻는다
	*@return 안내 경도
	*/
	public double getGuideX() { return this.guideX; }

	/** 
	 * 안내 위도를 얻는다
	*@return 안내 위도
	*/
	public double getguideY() { return this.guideY; }

	/** 
	 * 상세정보유무를 얻는다
	*@return haveDetailInfo 상세정보
	*/
	public boolean getHaveDetailInfo( int index ) {
		return this.haveDetailInfo[ index ];
	}

	/** 
	 * POI 종류를 얻는다 
	*@return POI종류
	*/
	public String getKind() { return this.kind; }

	/** 
	 * 상세 정보 최대 갯수를 얻는다 
	 * @return 상세정보최대개수
	 */
	public int getMaxDetailInfo() { return this.haveDetailInfo.length; }

	/** 
	 * POI가 속한 도곽코드를 얻는다
	*@return 도곽코드
	*/
	public long getMeshCode() { return this.meshCode; }

	/** 
	 * 정식명칭 얻기
	*@return 정식명칭
	*/
	public String getName() { return this.name; }

	/** 
	 * 찾아오는 길 얻기
	*@return 찾아오는 길
	*/
	public String getRouteRoad() { return this.road; }

	/** 
	 * 전화번호 얻기
	*@return 전화번호
	*/ 
	public String getTelNo() { return this.telNo; }

	/** 
	 * 전화번호 마지막 번호 얻기
	*@return 전화번호 마지막 번호( 예: 02-345-4000 ~ 02-345-4008인 경우 '8'이 된다. );
	*/
	public String getTelNoTo() { return this.telNoTo; }

	/** 
	 * 우편번호 얻기
	*@return 우편번호 
	*/
	public String getZipCode() { return this.zipCode; }
	
	/** 
	 * 팬션 아이디 얻기
	 * @return Returns the ps_id. 팬션 아이디
	 */
	public String getPs_id() {
		return ps_id;
	}
	
	/**
	 * businessDesc get
	 * @return Returns the businessDesc.
	 */
	public String getBusinessDesc() {
		return BusinessDesc;
	}
	/**
	 * businessDesc set
	 * @param businessDesc The businessDesc to set.
	 */
	public void setBusinessDesc(String businessDesc) {
		BusinessDesc = businessDesc;
	}
	/*
	public void setPs_id(String p)
	{
		this.ps_id = p;
	}
	*/
	
	
	/**
	 * @return the newAddress
	 */
	public String getNewAddress() {
		return newAddress;
	}

	/**
	 * @return the etcNewAddress
	 */
	public String getEtcNewAddress() {
		return etcNewAddress;
	}
}
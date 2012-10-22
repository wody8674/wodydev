package hts.gis.poi;


/* ������ ���� ������ ��´�.
*@param index DETAIL_BUSINESS : �����ȳ�
*DETAIL_RESERVE : ����
*DETAIL_FACILITY : �δ�ü�
*DETAIL_PARKING : ������
*DETAIL_GOODS : ��ǰ �� �޴�
*DETAIL_HOTEL : ȣ��
*DETAIL_MEMBER : ȸ����
*DETAIL_HOSPITAL : ����
*DETAIL_GOLF : ������
*DETAIL_SKI : ��Ű��
*DETAIL_CP : �ڷ�������
*DETAIL_FOOD : ������
*DETAIL_HOTEL_PRICE : ȣ�ڰ���
*DETAIL_MOVIE : ������ ����
*DETAIL_TOUR : ������
*@return true:������, false:����
*/

/** 
 * POI������ 
 * @author  JunHwa Park
 * */
public class POIDetailInfo extends POIDEntryBase {
	/** POI �� ���� -- �����ȳ� */
	public static final int DETAIL_BUSINESS =  0;
	/** POI �� ���� -- ����  */
	public static final int DETAIL_RESERVE	=  1;
	/** POI �� ���� -- �δ�ü� */
	public static final int DETAIL_FACILITY	=  2;
	/** POI �� ���� -- ������ */
	public static final int DETAIL_PARKING	=  3;
	/** POI �� ���� -- ��ǰ �� �޴� */
	public static final int DETAIL_GOODS	=  4;
	/** POI �� ���� -- ȣ�� */
	public static final int DETAIL_HOTELDETAIL_HOTEL	=  5;
	/** POI �� ���� -- ȸ���� */
	public static final int DETAIL_MEMBER	=  6;
	/** POI �� ���� -- ���� */
	public static final int DETAIL_HOSPITAL	=  7;
	/** POI �� ���� -- ������ */
	public static final int DETAIL_GOLF	=  8;
	/** POI �� ���� -- ��Ű�� */
	public static final int DETAIL_SKI	=  9;

	/** 
	 * �� ���� ���� 
	 * */
	public static final int MAX_DETAIL_INFO = 10;

	//�з��ڵ�
	protected String classCode;
	//�з���
	protected String className;
	//�����ڵ�
	protected String govCode;
	//������
	protected String govName;
	//�����ȣ
	protected String zipCode;
	//�ּ�
	protected String address;
	//��Ÿ�ּ�
	protected String etcAddress;
	//ã�ư��� ��
	protected String road;
	// �ش�����
	protected String floor;

	// ��ȭ��ȣ
	protected String telNo;
	// Ȯ����ȭ��ȣ
	protected String telNoTo;
	//����ڵ�Ϲ�ȣ
	protected String businessNo;
	//������ȣ
	protected long   meshCode;

	// POI��� 
	protected String grade;
	// ����
	protected String kind;
	// �߽���ǥ(x)
	protected double dispX;
	// �߽���ǥ(y)
	protected double dispY;
	// �ȳ���ǥ(x)
	protected double guideX;
	// �ȳ���ǥ(y)
	protected double guideY;
	// ���������� Flag
	protected boolean[] haveDetailInfo;
	// �Ҽ� ���̵�
	protected String ps_id;
	

	
	// ����̺갡�̵�
	protected String   driveGuideKind;
	// POI���ĸ�Ī
	protected String name;
	
	
	protected String BusinessDesc;
	

	
	// �ǹ�����
	protected int bldg_floor;
	// �ǹ���
	protected String bldg_name;	 
	//��Ȳ���ڵ�
	protected String airs_cd;
	
	// 2012.07.19 Jeong Jae Yo ���ּ� �߰�
	//���ּ�
	protected String newAddress;
	//��Ÿ ���ּ�
	protected String etcNewAddress;
	
	/** POI �� ���� -- CP ����*/	
	public static final int DETAIL_CP	=  14;
	/** POI �� ���� -- ������ */
	public static final int DETAIL_FOOD	=  10;
	/** POI �� ���� -- ȣ�ڰ������� */
	public static final int DETAIL_HOTEL_PRICE	=  12;
	/** POI �� ���� -- ������ ����*/
	public static final int DETAIL_MOVIE	=  13;
	/** POI �� ���� -- ������ */
	public static final int DETAIL_TOUR	=  11;
	/** �� ���� ����(��õ����) */
	public static final int MAX_DETAIL_INFO_R = 15;

	/** 
	 * ������
	 * @param id POIID
	 * @param classCode �з��ڵ�
	 * @param className �з���
	 * @param govCode �����ڵ�
	 * @param govName ������
	 * @param zipCode �����ȣ
	 * @param name POI���ĸ�Ī
	 * @param address �ּ�
	 * @param etcAddress ��Ÿ�ּ�
	 * @param road ã�ư��� ��
	 * @param floor �ش�����
	 * @param telNo ��ȭ��ȣ
	 * @param telNoTo Ȯ����ȭ��ȣ
	 * @param businessNo ����ڵ�Ϲ�ȣ
	 * @param meshCode ������ȣ
	 * @param grade POI��� 
 	 * @param kind ����
 	 * @param dispX �߽���ǥ(x)
 	 * @param dispY �߽���ǥ(y)
 	 * @param guideX �ȳ���ǥ(x)
	 * @param guideY �ȳ���ǥ(y)
	 * @param driveGuideKind ����̺갡�̵�
	 * @param bldg_floor �ǹ�����
	 * @param bldg_name �ǹ���
	 * @param haveDetailInfo ���������� Flag
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
	 * ������
	 * @param id POIID
	 * @param classCode �з��ڵ�
	 * @param className �з���
	 * @param govCode �����ڵ�
	 * @param govName ������
	 * @param zipCode �����ȣ
	 * @param name POI���ĸ�Ī
	 * @param address �ּ�
	 * @param etcAddress ��Ÿ�ּ�
	 * @param road ã�ư��� ��
	 * @param floor �ش�����
	 * @param telNo ��ȭ��ȣ
	 * @param telNoTo Ȯ����ȭ��ȣ
	 * @param businessNo ����ڵ�Ϲ�ȣ
	 * @param meshCode ������ȣ
	 * @param grade POI��� 
	 * @param kind ����
	 * @param dispX �߽���ǥ(x)
	 * @param dispY �߽���ǥ(y)
	 * @param guideX �ȳ���ǥ(x)
	 * @param guideY �ȳ���ǥ(y)
	 * @param driveGuideKind ����̺갡�̵�
	 * @param bldg_floor �ǹ�����
	 * @param bldg_name �ǹ���
	 * @param airs_cd ��Ȳ���ڵ�
	 * @param haveDetailInfo ���������� Flag
	 * @param ps_id �ҼǾ��̵�
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
	 * ������
	 * @param id POIID
	 * @param classCode �з��ڵ�
	 * @param className �з���
	 * @param govCode �����ڵ�
	 * @param govName ������
	 * @param zipCode �����ȣ
	 * @param name POI���ĸ�Ī
	 * @param address �ּ�
	 * @param etcAddress ��Ÿ�ּ�
	 * @param road ã�ư��� ��
	 * @param floor �ش�����
	 * @param telNo ��ȭ��ȣ
	 * @param telNoTo Ȯ����ȭ��ȣ
	 * @param businessNo ����ڵ�Ϲ�ȣ
	 * @param meshCode ������ȣ
	 * @param grade POI��� 
	 * @param kind ����
	 * @param dispX �߽���ǥ(x)
	 * @param dispY �߽���ǥ(y)
	 * @param guideX �ȳ���ǥ(x)
	 * @param guideY �ȳ���ǥ(y)
	 * @param driveGuideKind ����̺갡�̵�
	 * @param bldg_floor �ǹ�����
	 * @param bldg_name �ǹ���
	 * @param airs_cd ��Ȳ���ڵ�
	 * @param haveDetailInfo ���������� Flag
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
	 * ������
	 * @param id POIID
	 * @param classCode �з��ڵ�
	 * @param className �з���
	 * @param govCode �����ڵ�
	 * @param govName ������
	 * @param name POI���ĸ�Ī
	 * @param address �ּ�
	 * @param etcAddress ��Ÿ�ּ�
	 * @param telNo ��ȭ��ȣ
	 * @param telNoTo Ȯ����ȭ��ȣ
	 * @param dispX �߽���ǥ(x)
	 * @param dispY �߽���ǥ(y)
	 * 2009.12.16 ������ �߰�
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
	 * ������
	 * @param id POIID
	 * @param classCode �з��ڵ�
	 * @param className �з���
	 * @param govCode �����ڵ�
	 * @param govName ������
	 * @param zipCode �����ȣ
	 * @param name POI���ĸ�Ī
	 * @param address �ּ�
	 * @param etcAddress ��Ÿ�ּ�
	 * @param road ã�ư��� ��
	 * @param floor �ش�����
	 * @param telNo ��ȭ��ȣ
	 * @param telNoTo Ȯ����ȭ��ȣ
	 * @param businessNo ����ڵ�Ϲ�ȣ
	 * @param meshCode ������ȣ
	 * @param grade POI��� 
	 * @param kind ����
	 * @param dispX �߽���ǥ(x)
	 * @param dispY �߽���ǥ(y)
	 * @param guideX �ȳ���ǥ(x)
	 * @param guideY �ȳ���ǥ(y)
	 * @param driveGuideKind ����̺갡�̵�
	 * @param bldg_floor �ǹ�����
	 * @param bldg_name �ǹ���
	 * @param airs_cd ��Ȳ���ڵ�
	 * @param newAddress ���ּ�
	 * @param etcNewAddress ���ּҰǹ���ȣ
	 * @param haveDetailInfo ���������� Flag
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
	 * ������
	 * @param id POIID
	 * @param classCode �з��ڵ�
	 * @param className �з���
	 * @param govCode �����ڵ�
	 * @param govName ������
	 * @param zipCode �����ȣ
	 * @param name POI���ĸ�Ī
	 * @param address �ּ�
	 * @param etcAddress ��Ÿ�ּ�
	 * @param road ã�ư��� ��
	 * @param floor �ش�����
	 * @param telNo ��ȭ��ȣ
	 * @param telNoTo Ȯ����ȭ��ȣ
	 * @param businessNo ����ڵ�Ϲ�ȣ
	 * @param meshCode ������ȣ
	 * @param grade POI��� 
 	 * @param kind ����
 	 * @param dispX �߽���ǥ(x)
 	 * @param dispY �߽���ǥ(y)
 	 * @param guideX �ȳ���ǥ(x)
	 * @param guideY �ȳ���ǥ(y)
	 * @param driveGuideKind ����̺갡�̵�
	 * @param bldg_floor �ǹ�����
	 * @param bldg_name �ǹ���
	 * @param newAddress ���ּ�
	 * @param etcNewAddress ��Ÿ���ּ�
	 * @param haveDetailInfo ���������� Flag
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
	 * �ּ� ���
	*@return �ּ�
	*/
	public String getAddress() { return this.address; }

	/** 
	 * ��Ȳ���ڵ� ���
	*@return ��Ȳ���ڵ�
	*/
	public String getAirsCd() {
		return this.airs_cd;
	}

	/** 
	 * �ǹ������� ��´� 
	*@return Bldg_floor
	*/
	public int getBldgFloor() { return this.bldg_floor; }

	/** 
	 * BldgName�� ��´� 
	*@return BldgName
	*/
	public String getBldgName() { return this.bldg_name; }

	/** 
	 * ����� ��Ϲ�ȣ�� ��´�
	*@return ����� ��Ϲ�ȣ
	*/
	public String getBusinessNo() { return this.businessNo; }

	/** 
	 * �з� �ڵ� ���
	*@return �з��ڵ� 
	*/
	public String getClassCode() { return this.classCode; }

	/** 
	 * �з� �� ���
	*@return �з��� 
	*/
	public String getClassName() { return this.className; }

	/** 
	 * �߽� �浵�� ��´�
	*@return �߽� �浵
	*/
	public double getDisplayX() { return this.dispX; }

	/** 
	 * �߽� ������ ��´�
	*@return �߽� ����
	*/
	public double getDisplayY() { return this.dispY; }

	/** 
	 * ����̺� ���̵� ������ ��´�
	*@return ����̺� ���̵� ����
	*/
	public String getDriveGuideKind() { return this.driveGuideKind; }

	/** 
	 * �� �ּ� ���
	*@return �� �ּ� 
	*/
	public String getEtcAddress() { return this.etcAddress; }

	/** 
	 * �ǹ��� ��ġ�� ����
	*@return ����
	*/
	public String getFloor() { return this.floor; }

	/** 
	 * ���� �ڵ� ���
	*@return �����ڵ� 
	*/
	public String getGovCode() { return this.govCode; }

	/** 
	 * ������ ���
	*@return ������ 
	*/
	public String getGovName() { return this.govName; }

	/** 
	 * ����� ��´�
	*@return POI ��� 
	*/
	public String getGrade() { return this.grade; }

	/** 
	 * �ȳ� �浵�� ��´�
	*@return �ȳ� �浵
	*/
	public double getGuideX() { return this.guideX; }

	/** 
	 * �ȳ� ������ ��´�
	*@return �ȳ� ����
	*/
	public double getguideY() { return this.guideY; }

	/** 
	 * ������������ ��´�
	*@return haveDetailInfo ������
	*/
	public boolean getHaveDetailInfo( int index ) {
		return this.haveDetailInfo[ index ];
	}

	/** 
	 * POI ������ ��´� 
	*@return POI����
	*/
	public String getKind() { return this.kind; }

	/** 
	 * �� ���� �ִ� ������ ��´� 
	 * @return �������ִ밳��
	 */
	public int getMaxDetailInfo() { return this.haveDetailInfo.length; }

	/** 
	 * POI�� ���� �����ڵ带 ��´�
	*@return �����ڵ�
	*/
	public long getMeshCode() { return this.meshCode; }

	/** 
	 * ���ĸ�Ī ���
	*@return ���ĸ�Ī
	*/
	public String getName() { return this.name; }

	/** 
	 * ã�ƿ��� �� ���
	*@return ã�ƿ��� ��
	*/
	public String getRouteRoad() { return this.road; }

	/** 
	 * ��ȭ��ȣ ���
	*@return ��ȭ��ȣ
	*/ 
	public String getTelNo() { return this.telNo; }

	/** 
	 * ��ȭ��ȣ ������ ��ȣ ���
	*@return ��ȭ��ȣ ������ ��ȣ( ��: 02-345-4000 ~ 02-345-4008�� ��� '8'�� �ȴ�. );
	*/
	public String getTelNoTo() { return this.telNoTo; }

	/** 
	 * �����ȣ ���
	*@return �����ȣ 
	*/
	public String getZipCode() { return this.zipCode; }
	
	/** 
	 * �Ҽ� ���̵� ���
	 * @return Returns the ps_id. �Ҽ� ���̵�
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
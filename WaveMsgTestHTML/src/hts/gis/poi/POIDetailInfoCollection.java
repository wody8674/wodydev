package hts.gis.poi;

/**
* POI상세정보 Holder
* @author  JunHwa Park
* @see hts.gis.poi.POIDetailInfo
*/
public class POIDetailInfoCollection extends POICollection {

	/**
	 * 생성자
	 */
	public POIDetailInfoCollection() {
		super();
	}

	/**
	 * 생성자
	 * @param capa 개수
	 */
	public POIDetailInfoCollection(int capa) {
		super(capa);
	}
	
	/** 개체 추가 
	* @param pdi POIDetailInfo개체
	*/
	public void add( POIDetailInfo pdi) {
		super.add( pdi );
	}

	/** 하나의 POI상세정보 클래스를 얻는다
	*@param index 인덱스
	*/
	public POIDetailInfo get( int index ) {
		return (POIDetailInfo)super.getData(index);
	}

	/**
	 * 객체 삭제메소드
	 * @param i 인덱스
	 */
	public void clear(int i) {
		super.clear(i);
	}	

	/** 개체개수 가져오기
	* @return  개체개수
	*/
	public int getCount() {
		int count = super.count();
		return count;
	}
}
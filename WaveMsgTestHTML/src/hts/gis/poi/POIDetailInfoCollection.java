package hts.gis.poi;

/**
* POI������ Holder
* @author  JunHwa Park
* @see hts.gis.poi.POIDetailInfo
*/
public class POIDetailInfoCollection extends POICollection {

	/**
	 * ������
	 */
	public POIDetailInfoCollection() {
		super();
	}

	/**
	 * ������
	 * @param capa ����
	 */
	public POIDetailInfoCollection(int capa) {
		super(capa);
	}
	
	/** ��ü �߰� 
	* @param pdi POIDetailInfo��ü
	*/
	public void add( POIDetailInfo pdi) {
		super.add( pdi );
	}

	/** �ϳ��� POI������ Ŭ������ ��´�
	*@param index �ε���
	*/
	public POIDetailInfo get( int index ) {
		return (POIDetailInfo)super.getData(index);
	}

	/**
	 * ��ü �����޼ҵ�
	 * @param i �ε���
	 */
	public void clear(int i) {
		super.clear(i);
	}	

	/** ��ü���� ��������
	* @return  ��ü����
	*/
	public int getCount() {
		int count = super.count();
		return count;
	}
}
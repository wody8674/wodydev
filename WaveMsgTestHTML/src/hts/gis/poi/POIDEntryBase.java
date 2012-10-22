package hts.gis.poi;

import java.io.*;

/** 
 * POI ���� ���� ����(id) 
 * @author  JunHwa Park
 * */
public class POIDEntryBase implements Serializable {
	// POI ID
	private int id;
	
	/** 
	 * ������ 
	* @param id POIID
	*/
	public POIDEntryBase( int id ) {
		this.id = id;
	}
	/** 
	 * POI ID�� ��´�
	* @return POI ID
	*/
	public int getID() { return this.id; }
}
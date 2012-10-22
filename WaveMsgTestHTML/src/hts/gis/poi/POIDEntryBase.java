package hts.gis.poi;

import java.io.*;

/** 
 * POI 정보 공통 사항(id) 
 * @author  JunHwa Park
 * */
public class POIDEntryBase implements Serializable {
	// POI ID
	private int id;
	
	/** 
	 * 생성자 
	* @param id POIID
	*/
	public POIDEntryBase( int id ) {
		this.id = id;
	}
	/** 
	 * POI ID를 얻는다
	* @return POI ID
	*/
	public int getID() { return this.id; }
}
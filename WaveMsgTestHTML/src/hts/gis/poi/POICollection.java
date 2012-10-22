package hts.gis.poi;

import java.io.*;

/** 
 * 복수개의 클래스를 리턴하는 경우에 사용되어 지는 클래스 holder의 상위 클래스 
 * @author  JunHwa Park
 * */
public class POICollection extends Object implements Serializable {
	/* 개체개수 */
	private Object[] data;
	/* Data 개수 */
	private int numOfData;
	/* 초기화 개체개수 */
	private int initCapa;
	/* 전체개수 */
	private int totalCount =0;
	/* Start Rownum */
	private int offset = 0;

	/** 
	 * 생성자 -- 초기 홀더 사이즈는 10
	*/
	public POICollection() {
		this(10);
	}

	/** 
	 * 생성자 
	* @param capa 초기홀더사이즈 
	*/
	public POICollection( int capa ) {
		totalCount =0;
		offset = 0;
		initCapa = capa;
		numOfData = 0;
		data = new Object[ capa ];
	}

	/** 
	 * 개체 추가 
	* @param o 개체
	*/
	protected void add( Object o ) {
		if ( o != null ) {
			data[numOfData] = o;
			numOfData++;
			if ( numOfData >= data.length ) {
				Object objs[] = new Object[ data.length + (initCapa / 2) ];
				System.arraycopy( data, 0, objs, 0, data.length );
				data = objs;
				objs = null;
			}
		}
	}

	/** 
	 * 저장되어 있는 오브젝트를 삭제한다 
	 * */
	public void clear() {
		for ( int i=0; i<numOfData; i++) {
			data[i] = null;
		}
		numOfData = 0;
	}

	/** 
	 * 저장되어 있는 특정 오브젝트를 삭제한다 
	 * @param i n번째개체
	*/
	public void clear(int i) {
		data[i] = null;
	}

	/** 
	 * 저장되어 있는 오브젝트의 갯수를 얻는다 
	* @return 오브젝트갯수
	*/
	public int count() {
		return numOfData;
	}

	/** 
	 * 저장되어 있는 오브젝트에서 index로 지정된 Data를 리턴
	* @return 오브젝트(index 번째)
	*/
	protected Object getData(int index) {
		if ( index >=0 && index < numOfData ) {
			return data[index];
		}
		return null;
	}

	/** 
	 * 리턴되는 결과행(row)의 시작 index를 얻는다.
	 * @return offset 결과행(row)의 시작 index
	 */
	public int getOffset() { return this.offset; }

	/** 
	 * 결과 행(ResultSet)의 전체 갯수를 얻는다 
	 * @return totalCount 전체개수
	 */
	public int getTotalCount() { return this.totalCount; }

	/** 
	 * 전체개수와 Offset값 Setting
	 * @param tCnt 전체개수
	 * @param off  Offset값
	 */
	public void setReturnInfo( int tCnt, int off) {
		totalCount = tCnt;
		offset = off;
	}

	/** 
	 * Object class의 toString() override -- debug 용 
	* @return 객체정보
	*/
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append( getClass().getName() );sb.append( "\n");

		sb.append( "numOfData=" ); 
		sb.append( numOfData);sb.append( "\n");
		sb.append( "intCapa="); sb.append( initCapa );
		sb.append( "\n");

		for ( int i=0; i<numOfData;i++) {
			Object o = getData(i);
			if ( o != null ) {
				sb.append( "data[" );sb.append( i ); sb.append( "]=" ); sb.append( o );
			}
			else {
				sb.append( "data[" );sb.append( i ); sb.append( "]=" ); sb.append( "null" );
			}
		}

		return sb.toString();
	}
}
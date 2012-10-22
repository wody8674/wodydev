package hts.gis.poi;

import java.io.*;

/** 
 * �������� Ŭ������ �����ϴ� ��쿡 ���Ǿ� ���� Ŭ���� holder�� ���� Ŭ���� 
 * @author  JunHwa Park
 * */
public class POICollection extends Object implements Serializable {
	/* ��ü���� */
	private Object[] data;
	/* Data ���� */
	private int numOfData;
	/* �ʱ�ȭ ��ü���� */
	private int initCapa;
	/* ��ü���� */
	private int totalCount =0;
	/* Start Rownum */
	private int offset = 0;

	/** 
	 * ������ -- �ʱ� Ȧ�� ������� 10
	*/
	public POICollection() {
		this(10);
	}

	/** 
	 * ������ 
	* @param capa �ʱ�Ȧ�������� 
	*/
	public POICollection( int capa ) {
		totalCount =0;
		offset = 0;
		initCapa = capa;
		numOfData = 0;
		data = new Object[ capa ];
	}

	/** 
	 * ��ü �߰� 
	* @param o ��ü
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
	 * ����Ǿ� �ִ� ������Ʈ�� �����Ѵ� 
	 * */
	public void clear() {
		for ( int i=0; i<numOfData; i++) {
			data[i] = null;
		}
		numOfData = 0;
	}

	/** 
	 * ����Ǿ� �ִ� Ư�� ������Ʈ�� �����Ѵ� 
	 * @param i n��°��ü
	*/
	public void clear(int i) {
		data[i] = null;
	}

	/** 
	 * ����Ǿ� �ִ� ������Ʈ�� ������ ��´� 
	* @return ������Ʈ����
	*/
	public int count() {
		return numOfData;
	}

	/** 
	 * ����Ǿ� �ִ� ������Ʈ���� index�� ������ Data�� ����
	* @return ������Ʈ(index ��°)
	*/
	protected Object getData(int index) {
		if ( index >=0 && index < numOfData ) {
			return data[index];
		}
		return null;
	}

	/** 
	 * ���ϵǴ� �����(row)�� ���� index�� ��´�.
	 * @return offset �����(row)�� ���� index
	 */
	public int getOffset() { return this.offset; }

	/** 
	 * ��� ��(ResultSet)�� ��ü ������ ��´� 
	 * @return totalCount ��ü����
	 */
	public int getTotalCount() { return this.totalCount; }

	/** 
	 * ��ü������ Offset�� Setting
	 * @param tCnt ��ü����
	 * @param off  Offset��
	 */
	public void setReturnInfo( int tCnt, int off) {
		totalCount = tCnt;
		offset = off;
	}

	/** 
	 * Object class�� toString() override -- debug �� 
	* @return ��ü����
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
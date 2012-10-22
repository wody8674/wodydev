package hts.gis.poi;
import hts.gis.common.GISConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;



public class POIMakerBean {

	boolean isDefaultLog = true;
	boolean isDebug = true;
	
	/**
	 * poi이름 리스트를 주면 해당 poi정보 호출
	 * 
	 * @param poiNmList
	 * @return
	 * @throws java.sql.SQLException
	 */
	public POIDetailInfoCollection searchPoiNameList(List poiNmList) 
			throws java.sql.SQLException {

		long curTime = System.currentTimeMillis();
		java.util.Date dt = new java.util.Date(curTime);
		
		if ( isDefaultLog ) {
			System.out.println("::: == GIS == ::: searchPoiNameList ::: Start Time==" + dt.toString());
			System.out.println("::: == GIS == ::: searchPoiNameList(poiNmList)::: " + poiNmList);
		}
		
		if (poiNmList == null)
		{
			if ( isDefaultLog ) {
				long curETime = System.currentTimeMillis();
				java.util.Date et = new java.util.Date(curETime);
				System.out.println("::: == GIS == ::: searchNewAddressByName ::: End Time==" + et.toString());
			}
			return null;
		} 
		
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement pss = null;
		PreparedStatement psCoord = null;
		PreparedStatement psCnt = null;

		ResultSet rs = null;
		ResultSet rss = null;
		ResultSet rsCoord = null;
		ResultSet rsCnt = null;

		POIDetailInfoCollection dataList = new POIDetailInfoCollection();
		POIDetailInfo data;

		double x=0, y=0;
		
		Vector list = new Vector();
		
		try {
			
			StringBuffer sb = new StringBuffer();
			conn = GISConnectionManager.getConnection();
			
			sb.append("\n SELECT POI_ID"); 
			sb.append("\n      , SEARCH_NAME"); 
			sb.append("\n      , DISP_X"); 
			sb.append("\n      , DISP_Y");
			sb.append("\n      , CASE");
			sb.append("\n            WHEN JIBUN_S IS NULL OR JIBUN_S = 0");
			sb.append("\n               THEN ADDRESS||' '||JIBUN_M");
			sb.append("\n            ELSE");
			sb.append("\n               ADDRESS||' '||JIBUN_M||'-'||JIBUN_S");
			sb.append("\n        END AS ADDRESS");
			sb.append("\n      , ZIP_CD");
			sb.append("\n      , DECODE(EXIST_CHECK, '1', 'TRUE', 'FALSE') AS EXIST_CHECK"); 
			sb.append("\n   FROM (SELECT GC.*, '1' AS EXIST_CHECK FROM GPTM_COMMON GC) GC"); 
			sb.append("\n       ,(SELECT SEARCH_NAME"); 
			sb.append("\n           FROM ("); 
			
			int len = poiNmList.size();
			sb.append("\n     SELECT '"+ ((String) poiNmList.get(0)).trim() +"' AS SEARCH_NAME FROM DUAL"); 
			for (int i=1; i<len; i++) {
				sb.append("\n     UNION ALL");
				sb.append("\n     SELECT '"+ ((String) poiNmList.get(i)).trim() +"' AS SEARCH_NAME FROM DUAL");
			}
			
			sb.append("\n                )"); 
			sb.append("\n         ) "); 
			sb.append("\n  WHERE 1=1"); 
			sb.append("\n    AND DISP_NAME(+) = SEARCH_NAME");

			
			if ( isDebug ) {
				System.out.println( "::: == GIS == ::: searchNewAddressByName(query) : " + sb.toString() );
			}
			ps = conn.prepareStatement( sb.toString() );
			
			rs = ps.executeQuery();

			int poiId = 0;
			String poiNm = "";
			double dispX = 0.0;
			double dispY = 0.0;
			String addr = "";
			String zipcd = "";
			String classCd = "";
			
			while ( rs.next() ) {
				
				poiId = rs.getInt(1);
				poiNm = rs.getString(2);
				dispX = rs.getDouble(3);
				dispY = rs.getDouble(4);
				addr = rs.getString(5);
				zipcd  = rs.getString(6);
				classCd = rs.getString(7);
				
				data = new POIDetailInfo(poiId, classCd, null, null, null,
						poiNm, addr, zipcd, null, null, dispX, dispY);
				dataList.add(data);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("::: == GIS == :::" + e.toString());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			if (rss != null)
				try {
					rss.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			if (rsCnt != null)
				try {
					rsCnt.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			if (rsCoord != null)
				try {
					rsCoord.close();
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e5) {
					e5.printStackTrace();
				}
			if (pss != null)
				try {
					pss.close();
				} catch (Exception e6) {
					e6.printStackTrace();
				}
			if (psCnt != null)
				try {
					psCnt.close();
				} catch (Exception e7) {
					e7.printStackTrace();
				}
			if (psCoord != null)
				try {
					psCoord.close();
				} catch (Exception e8) {
					e8.printStackTrace();
				}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				System.out.println("::: == GIS == ::: Close connection Excetion :" + ex.getMessage());
			}
			System.out.println("::: == GIS == ::: " + conn);
		}

		if ( isDefaultLog ) {
			long curETime = System.currentTimeMillis();
			java.util.Date et = new java.util.Date(curETime);
			System.out.println("::: == GIS == ::: searchNewAddressByName ::: End Time==" + et.toString());
		}
		
		return dataList;
	}

}

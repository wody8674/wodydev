package hts.gis.common;
/*
좌표변환
직각좌표계
  KATECH 원점1개 
  TM     각 국가별 고유의 원점들
타원체 좌표계
  WGS-84 전세계에서 사용
  Bessel 국가별 사용 -- 기준점을 알아야 한다.
*/
/**
 * 좌표변환 클래스
 * @author  JunHwa Park
 */
public class GeoMapping {

  public static final double a  = 6377397.155;
  public static final double ee = 0.006674372231315;

  public static final int false_e = 400000; // KATECH  
  public static final int false_n = 600000;   
  public static final int false_x = 500000; // TM
  public static final int false_y = 200000;

  public static final double en_m0        = 0.9999;
  public static final double m0           = 1.0D;
  public static final double origin_lon   = 128;

  public static final double A =  1.005037306048555;
  public static final double B =  0.005047849240300;
  public static final double C =  0.000010563786831;
  public static final double D =  0.000000020633322;

  public static int  BL_TO_WGS84  = 0x0100;
  public static int  BL_TO_EN     = 0x0200;
  public static int  BL_TO_TM     = 0x0300;

  public static int  WGS84_TO_BL  = 0x0001;
  public static int  WGS84_TO_EN  = 0x0201;
  public static int  WGS84_TO_TM  = 0x0301;

  public static int  EN_TO_BL     = 0x0002;
  public static int  EN_TO_WGS84  = 0x0102;
  public static int  EN_TO_TM     = 0x0302;

  public static int  TM_TO_BL     = 0x0003;
  public static int  TM_TO_WGS84  = 0x0103;
  public static int  TM_TO_EN     = 0x0203;


  public static double rad( double x ) {
	return ( x * Math.PI / 180 );
  }                        

  public static double fnxco(double olat) {
	double f;
  
	f=a*(1-ee)*((A*olat)-0.5*B*Math.sin(2*olat)+0.25*C*Math.sin(4*olat)
		-1./6.*D*Math.sin(6*olat));
	return f;
  }                        


/**Bessel 좌표를 Katech으로 변경 
 * 2009.08.04 수정 (try catch 문 삽입)
@param da 0:latitude, 1:longitude( 호출후 0에는 latitude, 1:longitude ) 
@return 기준점 
*/
  public static long BL_to_XY( double[] da ) {//la, lo
	double b, e_prime, N, origin_lat, nn, t;
	double xy_lon0 =0;
	double e, n, lat, lon;
	long nOption=0;
	
	try {
		
		lat = da[0];
		lon = da[1];
		
	  
		if (lon < 126.0)
		{
		  nOption = 0;
		  xy_lon0=125.+10.405/3600.;
		}
		else if (lon < 128.0)
		{
		  nOption = 1;
		  xy_lon0=127.+10.405/3600.;
		}
		else if (lon > 128.0)
		{
		  nOption = 2;
		  xy_lon0=129.+10.405/3600.;
		}
	  
		origin_lat = rad(38.0);
	  
		lon -=xy_lon0;
		lon = rad(lon);
		lat = rad(lat);
	  
		b = fnxco(lat)-fnxco(origin_lat);
		N = a/Math.sqrt(1-ee*Math.pow(Math.sin(lat),2.0D));
		e_prime=ee/(1-ee);
		nn=e_prime*Math.pow(Math.cos(lat),2.0D);
		t=Math.tan(lat);
	  
		e = m0*(lon * N* Math.cos(lat)+Math.pow(lon,3.0D)/6.*N*Math.pow(Math.cos(lat),3.0D)*(1-t*t+nn)
		   +Math.pow(lon,5.0D)/120.0D*N*Math.pow(Math.cos(lat),5.0D)*(5-18*t*t+Math.pow(t,4.0D)));
		n = m0*(b + Math.pow(lon, 2.0D)/2.0D*N*Math.sin(lat)*Math.cos(lat)
		   +Math.pow(lon,4.0D)/24.0D*N*Math.sin(lat)*Math.pow(Math.cos(lat),3.0D)*(5-t*t+9*nn));
	  
		da[0] = ( n+false_x );// lat ?la
		da[1] = ( e+false_y );// lon ?lo
		
	} catch (Exception ex) {
		System.out.println("::: == GIS[Common] == ::: BL_to_XY Error!! :::  ");
		ex.printStackTrace();
	}
	
	return nOption;
  }                        

/**Katech 좌표를 Bessel로 변경 
 * 2009.08.04 수정 (try catch 문 삽입)
@param nOption 기준점 0, 1, 2
@param da 0:latitude, 1:longitude( 호출후 0에는 latitude, 1:longitude ) 
*/
  public static void XY_to_BL(long nOption, double[] da)  { //la,lo
	double n0,phi1, BN, nm, error, origin_lat, nn, M, N, t;
	double lon, lat;
	double xy_lon0=0;
	
	try {
		
		lat = da[0] - false_x;
		lon = da[1] - false_y;
		
		System.out.println("lat : " + lat);
		System.out.println("lon : " + lon);
	  
		if    (nOption == 0)  xy_lon0=125.+10.405/3600.;
		else if (nOption == 1)  xy_lon0=127.+10.405/3600.;
		else if (nOption == 2)  xy_lon0=129.+10.405/3600.;
	  
		origin_lat = rad(38.);
		n0=fnxco(origin_lat);
		phi1=origin_lat;
	  
		System.out.println("::: == GIS[Common] == ::: XY_to_BL Do_While Start!! :::  ");
		
		/*
		 * 2009.08.17 do~while 100회 루프 시 break 기능 추가
		 */
		
		int limit = 0;
		
		do {
		  BN=fnxco(phi1);
		  nm=n0+lat/m0;
		  error=(BN-nm)*Math.pow((1-ee*Math.sin(phi1)*Math.sin(phi1)), 1.5)/(a*(1-ee));
		  phi1-=error;
		  
		  if (limit == 100) {
			  break;
		  }
		  
		  limit++;
		  
		}while(Math.abs(error)>10e-10);
		
		System.out.println("::: == GIS[Common] == ::: XY_to_BL Do_While End!! :::  ");
	  
		nn=ee/(1-ee)*Math.pow(Math.cos(phi1),2.0D);
		M = a*(1-ee)/Math.pow((1-ee*Math.pow(Math.sin(phi1),2.0D)),1.5);
		N = a/Math.sqrt(1-ee*Math.pow(Math.sin(phi1),2.0D));
		t=Math.tan(phi1);
	  
		lat=phi1-lon*lon*t/(2*M*N*m0*m0)
		  +Math.pow(lon, 4.0D)*t/(24*M*Math.pow(N, 3.0D)+Math.pow(m0, 4.0D))*(5+3*t*t+nn-9*t*t*nn);
		lon=lon/(N*m0*Math.cos(phi1))-Math.pow(lon,3.0D)/(6*Math.pow(N, 3.0D)*Math.pow(m0, 3.0D)*Math.cos(phi1))*(1+2*t*t+nn)
		   +Math.pow(lon, 5)/(120*Math.pow(N, 5.0D)*Math.pow(m0, 5.0D)*Math.cos(phi1))*(5+28*t*t+24*Math.pow(t, 4.0D));
	  

		da[0] = lat*180.0D/Math.PI;//la
		da[1] = lon*180.0D/Math.PI+xy_lon0; //lo
		
	} catch (Exception ex) {
		System.out.println("::: == GIS[Common] == ::: XY_to_BL Error!! :::  ");
		ex.printStackTrace();
	}
  
  }      

/**Bessel좌표를 Katech으로 변환
 * 2009.08.04 수정 (try catch 문 삽입)
@param da (0):lat, (1):lon
*/
  public static void BL_to_EN( double[] da)  {//la,lo
	double b, e_prime, N, origin_lat, nn, t;
	double lon, lat, e, n;
  
	try {
		
		lat = da[0];
		lon = da[1];
	  
		origin_lat = rad(38.0);
	  
		lon -=origin_lon;
		lon = rad(lon);
		lat = rad(lat);
	  
		b = fnxco(lat)-fnxco(origin_lat);
		N = a/Math.sqrt(1-ee*Math.pow(Math.sin(lat),2.0D));
		e_prime=ee/(1-ee);
		nn=e_prime*Math.pow(Math.cos(lat),2.0D);
		t=Math.tan(lat);
	  
		e = en_m0*(lon * N* Math.cos(lat)+Math.pow(lon,3.0D)/6.0D*N*Math.pow(Math.cos(lat),3.0D)*(1-t*t+nn)
		   +Math.pow(lon,5.0D)/120.0D*N*Math.pow(Math.cos(lat),5.0D)*(5-18*t*t+Math.pow(t,4.0D)));
		n = en_m0*(b + Math.pow(lon, 2.0D)/2.0D*N*Math.sin(lat)*Math.cos(lat)
		   +Math.pow(lon,4.0D)/24.0D*N*Math.sin(lat)*Math.pow(Math.cos(lat),3.0D)*(5-t*t+9*nn));
		
		
		da[1] = (e+false_e );
		da[0] = (n+false_n );
		
	} catch(Exception ex) {
		
		System.out.println("::: == GIS[Common] == ::: BL_to_EN Error!! :::  ");
		ex.printStackTrace();
		
	}
	
  }                        
  
/**Katech좌표를 Bessel으로 변환
 * 2009.08.04 수정 (try catch 문 삽입)
@param da (0):lat, (1):lon
*/
  public static void EN_to_BL( double[] da)//la,lo
  {
	double n0,phi1, BN, nm, error, origin_lat, nn, M, N, t;
	double lon, lat;
  
	try {
	
		lon = da[1] - false_e;
		lat = da[0] - false_n;
	  
		origin_lat = rad(38.0D);
		n0=fnxco(origin_lat);
		phi1=origin_lat;
	  
		System.out.println("::: == GIS[Common] == ::: EN_to_BL Do_While Start!! :::  ");
		
		/*
		 * 2009.08.17 do~while 100회 루프 시 break 기능 추가
		 */
		
		int limit = 0;
		
		do{
		  BN=fnxco(phi1);
		  nm=n0+lat/en_m0;
		  error=(BN-nm)*Math.pow((1-ee*Math.sin(phi1)*Math.sin(phi1)), 1.5)/(a*(1-ee));
		  phi1-=error;
		  
		  if (limit == 100) {
			  break;
		  }
		  
		  limit++;
		  
		}while(Math.abs(error)>10e-10);
		
		System.out.println("::: == GIS[Common] == ::: EN_to_BL Do_While End!! :::  ");
	  
		nn=ee/(1-ee)*Math.pow(Math.cos(phi1),2.0D);
		M = a*(1-ee)/Math.pow((1-ee*Math.pow(Math.sin(phi1),2.0D)),1.5);
		N = a/Math.sqrt(1-ee*Math.pow(Math.sin(phi1),2.0D));
		t=Math.tan(phi1);
	  
		lat=phi1-lon*lon*t/(2*M*N*en_m0*en_m0)
		  +Math.pow(lon, 4.0D)*t/(24*M*Math.pow(N, 3.0D)+Math.pow(en_m0, 4.0D))*(5+3*t*t+nn-9*t*t*nn);
		lon=lon/(N*en_m0*Math.cos(phi1))-Math.pow(lon,3.0D)/(6*Math.pow(N, 3.0D)*Math.pow(en_m0, 3.0D)*Math.cos(phi1))*(1+2*t*t+nn)
		   +Math.pow(lon, 5)/(120*Math.pow(N, 5.0D)*Math.pow(en_m0, 5.0D)*Math.cos(phi1))*(5+28*t*t+24*Math.pow(t, 4.0D));
	  
		
		da[0] = ( lat*180./Math.PI );//la
		da[1] = ( lon*180./Math.PI+origin_lon );//lo
		
	} catch (Exception e) {
		
		System.out.println("::: == GIS[Common] == ::: EN_to_BL Error!! :::  ");
		e.printStackTrace();
		
	}
	
  }                        
  
  // double *lat, double *lng
  /*
   * 2009.08.04 수정 (try catch 문 삽입)
   */
  public static void   WGS_to_BL(double[] da)  {//la,lo
	int       dtx = 128,  /* unit:meter*/
			dty = -481,
			dtz = -664;
	double      Bessel_a = 6377397.155, /* Equatorial radius for Bessel meters */
			Bessel_f,  /* Flattening ratio for the Bessel Ellipse */
			wgs84_a = 6378137, /* W\Equatorial radius for Wgs84l meters */
			wgs84_f,  /* Flattening ratio for the Wgs84 Ellipse */
			wgs84_e2,
			dta,dtf,Q,L,S,Rn,Rm,dtlat,dtlng;
  
	try {
		
		Bessel_f = 1/299.1528128;
		wgs84_f = 1/298.257223563;
		dta = Bessel_a - wgs84_a ;
		dtf = Bessel_f - wgs84_f ;
		wgs84_e2 = (2 - wgs84_f) * wgs84_f;
		Q = (Math.PI/180) * (da[0]);      /* Y */
		L = (Math.PI/180) * (da[1]);      /* X */
		S = (Math.PI / (180.0 * 3600.0) );    /* radian / 뷳 */
		Rn = wgs84_a / Math.pow((1-wgs84_e2*(Math.sin(Q)*Math.sin(Q))),0.5);
		Rm = wgs84_a * (1-wgs84_e2) / Math.pow((1-wgs84_e2*(Math.sin(Q)*Math.sin(Q))),1.5);
		/* dtlat,dtlng in radians */
		dtlat = ( dtz * Math.cos(Q) - (dtx*Math.sin(Q)*Math.cos(L)) -  dty*Math.sin(Q)*Math.sin(L) +
		((wgs84_a*dtf + wgs84_f*dta) * Math.sin(2*Q)))/Rm;
		dtlng = ((dty* Math.cos(L)) - (dtx*Math.sin(L)))/(Rn * Math.cos(Q));
		dtlat *= 180 / Math.PI;
		dtlng *= 180 / Math.PI;
		
		da[0] = da[0] + dtlat;
		da[1] = da[1] + dtlng;
		
	} catch (Exception e) {
		
		System.out.println("::: == GIS[Common] == ::: WGS_to_BL Error!! :::  ");
		e.printStackTrace();
		
	}
	
	
  }                        
  
  /*
   * 2009.08.04 수정 (try catch 문 삽입)
   */
  public static void   BL_to_WGS( double[] da)  {//la,lo
	int       dtx = -128,  /* unit:meter*/
			dty = 481,
			dtz = 664;
	double      Bessel_a = 6377397.155, /* Equatorial radius for Bessel meters */
			Bessel_f,  /* Flattening ratio for the Bessel Ellipse */
			Bessel_e2,
			wgs84_a = 6378137, /* W\Equatorial radius for Wgs84l meters */
			wgs84_f,  /* Flattening ratio for the Wgs84 Ellipse */
			dta,dtf,Q,L,S,Rn,Rm,dtlat,dtlng;
  
	try {
		
		Bessel_f = 1/299.1528128;
		wgs84_f = 1/298.257223563;
		dta = wgs84_a - Bessel_a;
		dtf = wgs84_f - Bessel_f;
		Bessel_e2 = (2 - Bessel_f) * Bessel_f;
		Q = (Math.PI/180) * (da[0]);      /* Y */
		L = (Math.PI/180) * (da[1]);      /* X */
		S = (Math.PI / (180.0 * 3600.0) );    /* radian / 뷳 */
		Rn = Bessel_a / Math.pow((1-Bessel_e2*(Math.sin(Q)*Math.sin(Q))),0.5);
		Rm = Bessel_a * (1-Bessel_e2) / Math.pow((1-Bessel_e2*(Math.sin(Q)*Math.sin(Q))),1.5);
		/* dtlat,dtlng in radians */
		dtlat = ( dtz * Math.cos(Q) - (dtx*Math.sin(Q)*Math.cos(L)) -  dty*Math.sin(Q)*Math.sin(L) +
		((Bessel_a*dtf + Bessel_f*dta) * Math.sin(2*Q)))/Rm;
		dtlng = ((dty* Math.cos(L)) - (dtx*Math.sin(L)))/(Rn * Math.cos(Q));
		dtlat *= 180 / Math.PI;
		dtlng *= 180 / Math.PI;
	 
		da[0] = da[0] + dtlat;
		da[1] = da[1] + dtlng;
		
	} catch (Exception e) {
		
		System.out.println("::: == GIS[Common] == ::: BL_to_WGS Error!! :::  ");
		e.printStackTrace();
		
	}
	
  }                        
  
  public static double geoDistance( double slon, double slat, double elon, double elat) {
	double[] da1 = { slat, slon };
	double[] da2 = { elat, elon };  
	
	BL_to_EN(da1);    
	BL_to_EN(da2);
	double _slon = da1[1], _slat = da1[0],
		   _elon = da2[1], _elat = da2[0];
		   
	return Math.abs(Math.sqrt((_slon-_elon)*(_slon-_elon) + (_slat-_elat)*(_slat-_elat)));
  }                        

/**
 * 2009.08.04 수정 (try catch 문 삽입)
@param nMode   GeoMapping의 상수선언 참조
@param nOption Bessel좌표 변경인 경우 기준점
@param coord   [0] : 경도 , [1]:위도
@return 0:success 1:fail
*/
  public static int geoTransform(int nMode, long[] nOption, double coord[] )  { //coord 
	if ( coord.length != 2 ) {
	  return -1;
	}
	
	try {
		
		double[] c = new double[ coord.length ];
		c[0] = coord[1];
		c[1] = coord[0];
		
		switch ((int)(nMode & 0xFF)) {
		  case 0x0001:  WGS_to_BL( c );      break;
		  case 0x0002:  EN_to_BL( c );     break;
		  case 0x0003:  XY_to_BL( nOption[0], c ); break;
		}
	  
		switch ((int)(nMode & 0xFF00)) {
		  case 0x0100:  BL_to_WGS( c ); break;
		  case 0x0200:  BL_to_EN( c );  break;
		  case 0x0300:  nOption[0] = BL_to_XY( c );  break;
		}
		coord[0] = c[1];
		coord[1] = c[0];
		
	} catch (Exception e) {
		System.out.println("::: == GIS[Common] == ::: geoTransform Error!! :::  ");
		e.printStackTrace();
	}
	
	return 0;
  } //geoTransForm      

 /** 중심좌표에서 반경 만큼 떨어진 거리에 잇는 좌표를 얻는다.
  * 2009.08.04 수정 (try catch 문 삽입)
 *@param lon 
 *@param lat
 *@param radius 반경( 단위:미터 )
 *@return [0]:좌상단경도, [1]:좌상단위도, [2]:우하단경도, [3]:우하단위도
 */
  public static double[] getBoundary( double lon, double lat, int radius ) {

	System.out.println("::: == GIS[Common] == ::: getBoundary(lon, lat, radius) :::  " + lon +", " + lat +", " + radius );
  	
	long[] orgs = new long[1];
  	double[] coords = { lon, lat };
  	double[] res = null;
  	
  	try {
  	  	
  	  	GeoMapping.geoTransform( BL_TO_TM, orgs, coords );
  	  	
  	  	double[] topLeft = { coords[0] - radius, coords[1] + radius };
  	  	double[] bottomRight={ coords[0] + radius, coords[1] - radius };
  	  	
  	  	GeoMapping.geoTransform( TM_TO_BL, orgs, topLeft );
  	  	GeoMapping.geoTransform( TM_TO_BL, orgs, bottomRight );
  	  	
  	  	res = new double[4];
  	  	res[0] = topLeft[0];
  	  	res[1] = topLeft[1];
  	  	res[2] = bottomRight[0];
  	  	res[3] = bottomRight[1];

  	} catch (Exception e) {
  		
  		System.out.println("::: == GIS[Common] == ::: getBoundary Error!! :::  ");
  		e.printStackTrace();
  		
  	}

	System.out.println("::: == GIS[Common] == ::: getBoundary(data) :::  " + res[0] +", " + res[1] +", "+ res[2] +", "+ res[3]);
  	
	return res;
  }                          



/**
 * 메소드 설명을 삽입하십시오.
 * 작성 날짜: (2003-02-11 오전 9:35:55)
 * @return double[]
 * @param x1 double
 * @param y1 double
 * @param x2 double
 * @param y2 double
 * @param sRange double
 * @param eRange double
 * @param wRange double
 */
public static double[] getLinefactor(double x1, double y1, double x2, double y2, double sRange, double eRange, double wRange) {

	System.out.println("::: == GIS[Common] == ::: getLinefactor( x1, y1, x2, y2, sRange, eRange, wRange) :::  " + x1 +", " + y1 +", " + x2 +", " + y2 +", " + sRange +", " + eRange +", " + wRange );
//입력인자 double x1, double y1, double x2, double y2, double sRange, double eRange, double wRanle

	double	sRange1;
	double	eRange1;
	double	wRange1;
	double	[]arrFactor;

	arrFactor = new double[8];
//	sRange1 = sRange / 90145.32877; 
//	eRange1 = eRange / 90145.32877;
//	wRange1 = wRange / 90145.32877;

	sRange1 = sRange / 110145.32877;
	eRange1 = eRange / 110145.32877;
	wRange1 = wRange / 110145.32877;
	
	arrFactor[0] = y1 - y2;
	arrFactor[1] = x2 - x1;

	arrFactor[2] = x2 - x1;
	arrFactor[3] = y2 - y1;
	if (arrFactor[1] < 0)
	{
		arrFactor[0] = arrFactor[0] * (-1);
		arrFactor[1] = arrFactor[1] * (-1);
	}
	if (arrFactor[3] < 0)
	{
		arrFactor[2] = arrFactor[2] * (-1);
		arrFactor[3] = arrFactor[3] * (-1);
	}
	

	if (y2 == y1)
	{
		arrFactor[4] = (arrFactor[1]) * (-1) * y1 - (wRange1 * arrFactor[1]);
		arrFactor[5] = (arrFactor[1]) * (-1) * y1 + (wRange1 * arrFactor[1]);
		if ((arrFactor[2] < 0 && x2 > x1) || (arrFactor[2] > 0 && x2 < x1))
		{
			arrFactor[6] = (arrFactor[2]) * (-1) * y1 - (eRange1 * arrFactor[2]);
			arrFactor[7] = (arrFactor[2]) * (-1) * y1 + (sRange1 * arrFactor[2]);	
		}
		else
		{
			arrFactor[6] = (arrFactor[2]) * (-1) * y1 + (eRange1 * arrFactor[2]);
			arrFactor[7] = (arrFactor[2]) * (-1) * y1 - (sRange1 * arrFactor[2]);	
		}
	}
	else if (x2 == x1)
	{
		arrFactor[6] = (arrFactor[3]) * (-1) * y1 - (eRange1 * arrFactor[3]);
		arrFactor[7] = (arrFactor[3]) * (-1) * y1 + (sRange1 * arrFactor[3]);
		if ((arrFactor[1] < 0 && x2 > x1) || (arrFactor[1] > 0 && x2 < x1))
		{
			arrFactor[4] = (arrFactor[1]) * (-1) * y1 - (wRange1 * arrFactor[1]);
			arrFactor[5] = (arrFactor[1]) * (-1) * y1 + (wRange1 * arrFactor[1]);	
		}
		else
		{
			arrFactor[4] = (arrFactor[1]) * (-1) * y1 + (wRange1 * arrFactor[1]);
			arrFactor[5] = (arrFactor[1]) * (-1) * y1 - (wRange1 * arrFactor[1]);	
		}
	}
	else 
	{
		arrFactor[4] = Math.sqrt((arrFactor[0] * arrFactor[0] + arrFactor[1] * arrFactor[1])) * wRange1 * (-1)
						- (arrFactor[0] * x1 + arrFactor[1] * y1); 
		arrFactor[5] = Math.sqrt((arrFactor[0] * arrFactor[0] + arrFactor[1] * arrFactor[1])) * wRange1 
						- (arrFactor[0] * x1 + arrFactor[1] * y1); 
		if ((arrFactor[2] * arrFactor[3] < 0 && x2 > x1) || (arrFactor[2] * arrFactor[3] > 0 && x2 < x1))
		{ 
			arrFactor[6] = Math.sqrt((arrFactor[2] * arrFactor[2] + arrFactor[3] * arrFactor[3])) * sRange1 * (-1)
							- (arrFactor[2] * x1 + arrFactor[3] * y1); 
			arrFactor[7] = Math.sqrt((arrFactor[2] * arrFactor[2] + arrFactor[3] * arrFactor[3])) * eRange1 
							- (arrFactor[2] * x1 + arrFactor[3] * y1); 
		}
		else if ((arrFactor[2] * arrFactor[3] < 0 && x2 < x1) || (arrFactor[2] * arrFactor[3] > 0 && x2 > x1))
		{
			arrFactor[6] = Math.sqrt((arrFactor[2] * arrFactor[2] + arrFactor[3] * arrFactor[3])) * eRange1 * (-1)
							- (arrFactor[2] * x1 + arrFactor[3] * y1); 
			arrFactor[7] = Math.sqrt((arrFactor[2] * arrFactor[2] + arrFactor[3] * arrFactor[3])) * sRange1 
							- (arrFactor[2] * x1 + arrFactor[3] * y1); 
		}
	}

	System.out.println("::: == GIS[Common] == ::: getLinefactor(data) :::  " + arrFactor[0] +", " + arrFactor[1] +", "+ arrFactor[2] +", "+ arrFactor[3] +", "+ arrFactor[4] +", "+ arrFactor[5] +", "+ arrFactor[6] +", "+ arrFactor[7]);
	
	return arrFactor;

}

 /** 중심좌표에서 반경 만큼 떨어진 거리에 있는 좌표를 얻는다.
 *@param lon 
 *@param lat
 *@param radius 반경( 단위:미터 )
 *@return [0]:좌상단경도, [1]:좌상단위도, [2]:우하단경도, [3]:우하단위도
 *@return [4]:우상단경도, [5]:우상단위도, [6]:좌하단경도, [7]:좌하단위도
 */
  public static double[] getBoundaryT( double lon, double lat, int radius ) {

	System.out.println("::: == GIS[Common] == ::: getBoundary(lon, lat, radius) :::  " + lon +", " + lat +", " + radius );
  	
	long[] orgs = new long[1];
  	double[] coords = { lon, lat };
  	
  	GeoMapping.geoTransform( BL_TO_TM, orgs, coords );
  	
  	double[] topLeft = { coords[0] - radius, coords[1] + radius };
  	double[] topRight = { coords[0] + radius, coords[1] + radius };
  	double[] bottomLeft={ coords[0] - radius, coords[1] - radius };
  	double[] bottomRight={ coords[0] + radius, coords[1] - radius };
  	
  	GeoMapping.geoTransform( TM_TO_BL, orgs, topLeft );
  	GeoMapping.geoTransform( TM_TO_BL, orgs, topRight );
  	GeoMapping.geoTransform( TM_TO_BL, orgs, bottomLeft );
  	GeoMapping.geoTransform( TM_TO_BL, orgs, bottomRight );
  	
  	double[] res = new double[8];
  	res[0] = topLeft[0];
  	res[1] = topLeft[1];
  	res[2] = topRight[0];
  	res[3] = topRight[1];
  	res[4] = bottomLeft[0];
  	res[5] = bottomLeft[1];
  	res[6] = bottomRight[0];
  	res[7] = bottomRight[1];
  	
	System.out.println("::: == GIS[Common] == ::: getBoundaryT(data) :::  " + res[0] +", " + res[1]);
	System.out.println("::: == GIS[Common] == ::: getBoundaryT(data) :::  " + res[2] +", " + res[3]);
	System.out.println("::: == GIS[Common] == ::: getBoundaryT(data) :::  " + res[4] +", " + res[5]);
	System.out.println("::: == GIS[Common] == ::: getBoundaryT(data) :::  " + res[6] +", " + res[7]);
	
	return res;
  }      

/**
 * 경위도 좌표로 도엽번호 추출
 * 작성 날짜: (2004-02-12 오후 6:12:08)
 * @return java.lang.String
 * @param fLon double
 * @param fLat double
 */
public static int[] getMesh(double[] fLon, double[] fLat) {

	double STD_LON_ST	= 124.0;
	double STD_LAT_ST		= 33.0;

	int fLonSize = fLon.length;

	System.out.println("::: == GIS[Common] == ::: getMesh[fLonSize] :::  " + fLonSize);
	int[]		dwCode = new int [fLonSize];

	double	lfLon = 0.0;
	double	lfLat = 0.0;
	int			nMX = 0;
	int 		nMY = 0;
	int			nMX1 = 0;
	int			nMY1 = 0;
	int			i;
	int			j;

	for(int k=0; k<fLon.length; k++)
	{
		if ((fLon[k] < STD_LON_ST) || (fLon[k] > STD_LON_ST + 8) || (fLat[k] < STD_LAT_ST) || fLat[k] >= (STD_LAT_ST + 6.0 ))
		{
			return dwCode;
		}

		if (fLat[k] > 39 )
		{
			return dwCode;
		}

		for (j =0; j < 8; j++)
		{
			if (fLon[k] >= (STD_LON_ST + (double)(j) ) && fLon[k] < (STD_LON_ST + (double)(j+1) ))
			{	
				lfLon = (STD_LON_ST + (double)(j) );
				nMX = j + 2;
			}
		}

		for (i =0; i < 9; i++)
		{
			if (fLat[k] >= (STD_LAT_ST + (double)(i) * 2.0/3.0) && fLat[k] < (STD_LAT_ST + (double)(i+1) * 2.0/3.0))
			{
				lfLat = (STD_LAT_ST + (double)(i) * 2.0/3.0);
				nMY = i + 1;
			}
		}

		for (j = 0; j < 8 ; j++)
		{
			if (fLon[k] >= (lfLon + (double)(j) / 8.0) && fLon[k] < (lfLon + (double)(j+1) / 8.0))
				nMX1 = j +1;
			if (fLat[k] >= (lfLat + (double)(j) /3.0 /4.0) && fLat[k] < (lfLat + (double)(j+1) /3.0 /4.0))
				nMY1 = j +1;
		}
	

		dwCode[k] = nMX*1000 + nMY*100 + nMX1*10 + nMY1;
	}

	/*
	System.out.println("::: == GIS[Common] == ::: getMesh[] :::  " + dwCode[0] +", " + dwCode[1] +", "+ dwCode[2] +", "+ dwCode[3]);
	
	if( fLonSize >= 7)
	{
		System.out.println("::: == GIS[Common] == ::: getMesh[] :::  "	+ dwCode[4] +", " + dwCode[5] +", "+ dwCode[6] +", "+ dwCode[7]);
	}
	if( fLonSize >= 10 )
	{
		System.out.println("::: == GIS[Common] == ::: getMesh[] :::  "	+ dwCode[8] +", " + dwCode[9] +", "+ dwCode[10] +", "+ dwCode[11]);
	}
	*/
	for(int s=0;s<fLonSize;s++)
	{
		System.out.println("::: == GIS[Common] == ::: getMesh["+s+"] :::  " + dwCode[s]);
	}
	
	return dwCode;
}

/**
 * @param double[] pt_a : 두 개의 Bessel좌표 중 한개([0]:lon, [1]:lat)
 * @param double[] pt_b : 두 개의 Bessel좌표 중 한개([0]:lon, [1]:lat)
 * @return : 거리값을 미터(m)단위로 리턴
 * @throws javax.naming.NamingException
 * @throws java.rmi.RemoteException
 * @throws java.sql.SQLException
 */
/**Being Used in Internal**/
public double GetDistanceBL( double[] pt_a, double[] pt_b)  throws javax.naming.NamingException, java.rmi.RemoteException, java.sql.SQLException	
{
	System.out.println("::: == GIS[GISPOI] == ::: GetDistanceBL(pt_a[0] : " + pt_a[0] );
	System.out.println("::: == GIS[GISPOI] == ::: GetDistanceBL(pt_a[1] : " + pt_a[1] );
	System.out.println("::: == GIS[GISPOI] == ::: GetDistanceBL(pt_b[0] : " + pt_b[0] );
	System.out.println("::: == GIS[GISPOI] == ::: GetDistanceBL(pt_b[1] : " + pt_b[1] );
	
	double dist = 0.0;
	dist = GeoMapping.geoDistance(pt_a[0], pt_a[1], pt_b[0], pt_b[1]);

	return dist;
}

public static void main (String args[])
{
	GeoMapping a = new GeoMapping();
	a.getBoundary(126.972527, 37.5851111, 1000);
}


}
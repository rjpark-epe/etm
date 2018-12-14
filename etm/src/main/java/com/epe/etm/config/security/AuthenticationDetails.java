package com.epe.etm.config.security;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;


/** 
 * 세션의 principal 말고 보조적으로 사용되는 범용 객체 
 * Detail로 들어간다.
 * 주의! 시큐리티 컨텍스트의 일부임으로 로그인 이전의 세션 데이터는 입력이 불가능하다. ex) 로그인 실패 수, 장바구니 .. 
 * 
 * WAS 재기동시 Serializable 매칭 문제는 거의 희막할테니 신경쓰지 않고 Map 대신 명확한 value를 사용한다.
 *  */
@Data
@EqualsAndHashCode(callSuper=true)
public class AuthenticationDetails extends WebAuthenticationDetails  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public AuthenticationDetails(HttpServletRequest request) {
		super(request);
	}
	
	/** 최초 로그인 시간 */
	private Date loginTime;
	/** 재 인증 시간 */
	private Date reCertTime;
	/** 프록시를 거치는 경우 앞단의 IP.  WebUtil.getForwardedIp 참고  */
	private String ip;
	/** 승인된 프로바이더의 이름. 이걸로 관리자 로그인지 구별 가능  */
	private String provider;
	
	
	
}

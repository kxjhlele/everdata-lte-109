package com.eversec.lte.constant;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eversec.common.output.FileOutput;
import com.eversec.lte.config.SdtpConfig;

/**
 * 
 * @author bieremayi
 * 
 */
public class SdtpConstants {

//	public static CharsetEncoder ENCODER;
//	public static CharsetDecoder DECODER;
	public static final short MAX_UNSIGNED_BYTE = Byte.MAX_VALUE * 2 + 1;
	public static final int MAX_UNSIGNED_SHORT = Short.MAX_VALUE * 2 + 1;
	public static final long MAX_UNSIGNED_INT = Integer.MAX_VALUE * 2l + 1;
	public static final String MAX_UNSIGNED_BYTE_STR = String
			.valueOf(MAX_UNSIGNED_BYTE);
	public static final String MAX_UNSIGNED_SHORT_STR = String
			.valueOf(MAX_UNSIGNED_SHORT);
	public static final String MAX_UNSIGNED_INT_STR = String
			.valueOf(MAX_UNSIGNED_INT);

	public static final Map<Integer, Integer> S1MME_PROCEDURE_MAP = new HashMap<>();
	
	public static final Map<Short, String> S1U_APP_TYPE_CODE_MAP = new HashMap<>();

	static {
//		ENCODER = Charset.forName("utf-8").newEncoder();
//		DECODER = Charset.forName("utf-8").newDecoder();
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.ATTACH,
				S1mmeProcedureType.ATTACH);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.CSFB,
				S1mmeProcedureType.EXTENDED_SERVICE_REQUEST);
		S1MME_PROCEDURE_MAP
				.put(CompSignalingProcedureType.DEDICATED_EPS_BEARER_CONTEXT_ACTIVATION,
						S1mmeProcedureType.DEDICATED_EPS_BEARER_CONTEXT_ACTIVATION);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.DETACH,
				S1mmeProcedureType.DETACH);
		S1MME_PROCEDURE_MAP.put(
				CompSignalingProcedureType.EPS_BEARER_CONTEXT_DEACTIVATION,
				S1mmeProcedureType.EPS_BEARER_CONTEXT_DEACTIVATION);
		S1MME_PROCEDURE_MAP.put(
				CompSignalingProcedureType.EPS_BEARER_CONTEXT_MODIFICATION,
				S1mmeProcedureType.EPS_BEARER_CONTEXT_MODIFICATION);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.EPS_BEARER_RELEASE,
				S1mmeProcedureType.ERAB_RELEASE);
		S1MME_PROCEDURE_MAP.put(
				CompSignalingProcedureType.EPS_BEARER_RESOURCE_ALLOCATION,
				S1mmeProcedureType.EPS_BEARER_RESOURCE_ALLOCATION);
		S1MME_PROCEDURE_MAP.put(
				CompSignalingProcedureType.EPS_BEARER_RESOURCE_MODIFY,
				S1mmeProcedureType.EPS_BEARER_RESOURCE_MODIFY);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.PAGING,
				S1mmeProcedureType.PAGING);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.PDN_CONNECTIVITY,
				S1mmeProcedureType.PDN_CONNECTIVITY);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.PDN_DISCONNECTION,
				S1mmeProcedureType.PDN_DISCONNECTION);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.S1_HANDOVER,
				S1mmeProcedureType.S1_HANDOVER);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.SERVICE_REQUEST,
				S1mmeProcedureType.SEVICE_REQUEST);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.SMS,
				S1mmeProcedureType.SMS);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.TAU,
				S1mmeProcedureType.TAU);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.UE_CONTEXT_RELEASE,
				S1mmeProcedureType.UE_CONTEXT_RELEASE);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.X2_HANDOVER,
				S1mmeProcedureType.X2_HANDOVER);
		S1MME_PROCEDURE_MAP.put(CompSignalingProcedureType.UNKNOWN,
				S1mmeProcedureType.UNKNOWN);
	}
	
	
	static {
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.GN_SIGNALING,"GNSIGN" );// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.S11_SIGNALING, "S11SIGN");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.XDR_BUSINESS,"OTHER");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.DNS, "DNS");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.MMS, "MMS");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.HTTP,"HTTP");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.FTP,  "FTP");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.EMAIL,  "EMAIL");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.VOIP, "VOIP");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.RTSP, "RTSP");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.IM, "IM");// =
		S1U_APP_TYPE_CODE_MAP.put((short) SdtpConstants.XDRType.P2P, "P2P");// =
	}

	// 2+2+4+1
	public static final int SDTP_HEADER_LENGTH = 9;
	public static final int SDTP_TOTALLENGTH_FIELD_LENGTH = 2;

	/**
	 * SDTP消息类型
	 * 
	 * @author bieremayi
	 * 
	 */
	public static class MessageType {
		public static final int VER_NEGO_REQ = 0x0001;// 版本协商请求
		public static final int VER_NEGO_RESP = 0x8001;// 版本协商应答
		public static final int LINK_AUTH_REQ = 0x0002;// 鉴权请求
		public static final int LINK_AUTH_RESP = 0x8002;// 鉴权响应
		public static final int LINK_CHECK_REQ = 0x0003;// 链路检测请求
		public static final int LINK_CHECK_RESP = 0x8003;// 链路检测应答
		public static final int LINK_REL_REQ = 0x0004;// 连接释放请求
		public static final int LINK_REL_RESP = 0x8004;// 连接释放应答
		public static final int NOTIFY_XDR_DATA_REQ = 0x0005;// XDR信令数据通知请求
		public static final int NOTIFY_XDR_DATA_RESP = 0x8005;// XDR信令数据通知应答
//		public static final int NOTIFY_CDR_OR_TDR_DATA_REQ = 0x0005;// CDR/TDR信令数据通知请求
//		public static final int NOTIFY_CDR_OR_TDR_DATA_RESP = 0x8005;// CDR/TDR信令数据通知应答
		public static final int XDR_RAW_DATA_SEND_REQ = 0x0006;// XDR对应原始数据传输
		public static final int XDR_RAW_DATA_SEND_RESP = 0x8006;// XDR对应原始数据传输应答
		public static final int LINK_DATA_CHECK_REQ = 0x0007;// 链路数据发送校验请求
		public static final int LINK_DATA_CHECK_RESP = 0x8007;// 链路数据发送校验应答
		public static final int XDR_RAW_DATA_QUERY_REQ = 0x0008;// XDR数据反查请求
		public static final int XDR_RAW_DATA_QUERY_RESP = 0x8008;// XDR数据反查应答
		public static final int NOTIFY_KPI_DATA_REQ = 0x0009;// KPI数据通知请求
		public static final int NOTIFY_KPI_DATA_RESP = 0x8009;// KPI数据通知应答
	}

	/**
	 * 合成XDR类型
	 * 
	 */
	public static class CompXDRType {
		public static final int CXDR_UNKNOWN = 0; // 合成信令XDR
		public static final int CXDR_SIGNALING = 1; // 合成信令XDR
		public static final int CXDR_APPLICATION = 2; // 合成业务XDR
		public static final int CXDR_UEMR = 3; // 合成MRXDR
	}

	/**
	 * 合成信令流程
	 * 
	 */
	public static class CompSignalingProcedureType {
		public static final int UNKNOWN = MAX_UNSIGNED_BYTE;
		public static final int ATTACH = 1;
		public static final int SERVICE_REQUEST = 2;
		public static final int PAGING = 3;
		public static final int TAU = 4;
		public static final int DETACH = 5;
		public static final int PDN_CONNECTIVITY = 6;
		public static final int PDN_DISCONNECTION = 7;
		public static final int EPS_BEARER_RESOURCE_ALLOCATION = 8;
		public static final int EPS_BEARER_RESOURCE_MODIFY = 9;
		public static final int EPS_BEARER_CONTEXT_DEACTIVATION = 10;
		public static final int EPS_BEARER_CONTEXT_MODIFICATION = 11;
		public static final int DEDICATED_EPS_BEARER_CONTEXT_ACTIVATION = 12;
		public static final int X2_HANDOVER = 13;
		public static final int S1_HANDOVER = 14;
		public static final int UE_CONTEXT_RELEASE = 15;
		public static final int EPS_BEARER_RELEASE = 16;
		public static final int CSFB = 17;
		public static final int SMS = 18;
	}

	/**
	 * s1mme信令流程
	 */
	public static class S1mmeProcedureType {

		public static final int UNKNOWN = MAX_UNSIGNED_BYTE;
		public static final int ATTACH = 1;
		public static final int SEVICE_REQUEST = 2;
		public static final int EXTENDED_SERVICE_REQUEST = 3;
		public static final int PAGING = 4;
		public static final int TAU = 5;
		public static final int DETACH = 6;
		public static final int PDN_CONNECTIVITY = 7;
		public static final int PDN_DISCONNECTION = 8;
		public static final int EPS_BEARER_RESOURCE_ALLOCATION = 9;
		public static final int EPS_BEARER_RESOURCE_MODIFY = 10;
		public static final int EPS_BEARER_CONTEXT_DEACTIVATION = 11;
		public static final int EPS_BEARER_CONTEXT_MODIFICATION = 12;
		public static final int DEDICATED_EPS_BEARER_CONTEXT_ACTIVATION = 13;
		public static final int X2_HANDOVER = 14;
		public static final int S1_HANDOVER = 15;
		public static final int S1_HANDIN = 16;
		public static final int INITIAL_CONTEXT_SETUP = 17;
		public static final int UE_CONTEXT_MODIFICATION = 18;
		public static final int UE_CONTEXT_RELEASE = 19;
		public static final int ERAB_RELEASE = 20;
		public static final int RESET = 21;
		public static final int ERROR_INDICATION = 22;
		public static final int S1_SETUP = 23;
		public static final int ENB_CONFIGURATION_UPDATE = 24;
		public static final int MME_CONFIGURATION_UPDATE = 25;
		public static final int OVERLOAD_START = 26;
		public static final int OVERLOAD_STOP = 27;
		public static final int IDENTITY_ACQUISITION = 28;
		public static final int AUTHENTICATION = 29;
		public static final int SECURITY_ACTIVATION = 30;
		public static final int SMS = 31;

	}

	/**
	 * XDR数据类型
	 */
	public static class XDRType {
		public static final int GN_SIGNALING = 0;
		public static final int S11_SIGNALING = 1;
		public static final int XDR_BUSINESS = 100;
		public static final int DNS = 101;
		public static final int MMS = 102;
		public static final int HTTP = 103;
		public static final int FTP = 104;
		public static final int EMAIL = 105;
		public static final int VOIP = 106;
		public static final int RTSP = 107;
		public static final int IM = 108;// 即时通信
		public static final int P2P = 109;
	}

	/**
	 * CDR数据类型
	 */
	public static class CDRType {
		public static final int ATTACH = 0;
		public static final int IDENTITY = 1;
		public static final int AUTHENTICATION = 2;
		public static final int DETACH = 3;
		public static final int PDP_ACTIVATION = 4;
		public static final int PDP_DEACTIVATION = 5;
		public static final int PDP_MODIFICATION = 6;
		public static final int RAB = 7;
		public static final int RAU = 8;
		public static final int BSSGP = 9;
		public static final int RANAP = 10;
		public static final int RELOCATION = 11;
		public static final int SERVICE_REQUEST = 12;
		public static final int PAGING_2G = 13;
		public static final int XDR_BUSINESS = 100;
		public static final int DNS = 101;
		public static final int MMS = 102;
		public static final int HTTP = 103;
		public static final int FTP = 104;
		public static final int EMAIL = 105;
		public static final int VOIP = 106;
		public static final int RTSP = 107;
		public static final int IM = 108;// 即时通信
		public static final int P2P = 109;
	}

	/**
	 * 移动版LTE XDR接口
	 * 
	 */
	public static class XDRInterface {
		public static final int UU = 1;
		public static final int X2 = 2;
		public static final int UE_MR = 3;
		public static final int CELL_MR = 4;
		public static final int S1MME = 5;
		public static final int S6A = 6;
		public static final int S11 = 7;
		public static final int S10 = 8;
		public static final int SGS = 9;
		public static final int S5S8 = 10;
		public static final int S1U = 11;
		public static final int GNC = 12;
		public static final int SIMPLE_UEMR = 100;
		public static final int SIP = 13;
		public static final int SV = 14;
		public static final int DIA = 15;
		public static final int RX = 16;
		public static final int HARASS = 17;
		
	}

	/**
	 * 联通版LTE SDR接口
	 * 
	 */
	public static class SDRInterface {
		public static final int S1MME = 31;
		public static final int S11 = 32;
		public static final int SGS = 33;
		public static final int S6A = 34;
	}

	public static enum SDRInterfaceType {
		A, Gb, IuCS, IuPS, Gn, S1MME, S11, SGs, S6a, S1U
	}

	public static class S1MMEType {
		public static final int ATTACH = 41;
		public static final int DETACH = 42;
		public static final int TAU = 43;
		public static final int PDN_CONNECTIVITY = 21;
		public static final int PDN_DISCONNECTION = 22;
		public static final int SEVICE_REQUEST = 24;
		public static final int UE_ALLOCATION = 25;
		public static final int UE_MODIFICATION = 26;
		public static final int EPS = 27;
		public static final int S1_SWITCH = 33;
		public static final int PAGING = 61;
		public static final int ERAB = 62;
		public static final int EMM = 1;
		public static final int ESM = 2;
		public static final int S1AP = 5;
		public static final int S1_MANAGEMENT = 6;
	}

	public static int getCompXDRType(int Interface) {
		switch (Interface) {
		case XDRInterface.UU:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.X2:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.UE_MR:
			return CompXDRType.CXDR_UEMR;
		case XDRInterface.CELL_MR:
			return CompXDRType.CXDR_UNKNOWN;
		case XDRInterface.S1MME:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.S6A:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.S11:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.S10:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.SGS:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.S5S8:
			return CompXDRType.CXDR_SIGNALING;
		case XDRInterface.S1U:
			return CompXDRType.CXDR_APPLICATION;
		case XDRInterface.GNC:
			return CompXDRType.CXDR_UNKNOWN;
		default:
			return CompXDRType.CXDR_UNKNOWN;
		}
	}

	public static class ProcedureType {
		/* Uu 流程类型编码 */
		public static final int RRC_CONN_STP = 1; // RRC连接建立
		public static final int RRC_SMC = 2; // 安全模式激活
		public static final int RRC_RE_CFG = 3; // RRC连接重配
		public static final int RRC_RE_EST = 4; // RRC连接重建
		public static final int RRC_REL = 5; // RRC连接释放
		public static final int RRC_HO_INTRACELL = 6; // 小区内部切换
		public static final int RRC_HO_INTRAENB = 7; // 基站内切换
		public static final int RRC_HO_INTERENB = 8; // 基站间切换
		public static final int RRC_HO_IN = 9; // 从其它RAT切入
		public static final int RRC_HO_OUT_RAT = 10; // 切出至其他RAT
		public static final int RRC_PAGING_PS = 11; // PS寻呼
		public static final int RRC_PAGING_CS = 12; // CS寻呼
		public static final int RRC_OTHER = 13; // 其它事件类型

		/* X2 流程类型编码 */

		public static final int X2_HANDOVER = 1;
		public static final int X2_HANDOVER_CANCEL = 2;
		public static final int X2_SETUP = 3;
		public static final int X2_RESET = 4;
		public static final int X2_ENB_CONFIGURATION_UPDATE = 5;
		public static final int X2_RESOURCE_STATUS_REPORTING = 6;
		public static final int X2_MOBILITY_SETTING_CHANGE = 7;
		public static final int X2_CELL_ACTIVATION = 8;
		public static final int X2_LOAD_INDICATION = 9;
		public static final int X2_ERROR_INDICATION = 10;

		/* S1-MME 流程类型编码 */
		public static final int S1MME_ATTACH = 1;
		public static final int S1MME_SEVICE_REQUEST = 2;
		public static final int S1MME_EXTENDED_SERVICE_REQUEST = 3;
		public static final int S1MME_PAGING = 4;
		public static final int S1MME_TAU = 5;
		public static final int S1MME_DETACH = 6;
		public static final int S1MME_PDN_CONNECTIVITY = 7;
		public static final int S1MME_PDN_DISCONNECTION = 8;
		public static final int S1MME_EPS_BEARER_RESOURCE_ALLOCATION = 9;
		public static final int S1MME_EPS_BEARER_RESOURCE_MODIFY = 10;
		public static final int S1MME_EPS_BEARER_CONTEXT_DEACTIVATION = 11;
		public static final int S1MME_EPS_BEARER_CONTEXT_MODIFICATION = 12;
		public static final int S1MME_DEDICATED_EPS_BEARER_CONTEXT_ACTIVATION = 13;
		public static final int S1MME_X2_SWITCH = 14;
		public static final int S1MME_S1_HANDOVER_PREPARATION = 15;
		public static final int S1MME_S1_HANDOVER = 16;
		public static final int S1MME_UE_CONTEXT_SETUP = 17;
		public static final int S1MME_UE_CONTEXT_MODIFICATION = 18;
		public static final int S1MME_UE_CONTEXT_RELEASE = 19;
		public static final int S1MME_ERAB_RELEASE = 20;
		public static final int S1MME_RESET = 21;
		public static final int S1MME_ERROR_INDICATION = 22;
		public static final int S1MME_S1_SETUP = 23;
		public static final int S1MME_ENB_CONFIGURATION_UPDATE = 24;
		public static final int S1MME_MME_CONFIGURATION_UPDATE = 25;
		public static final int S1MME_OVERLOAD_START = 26;
		public static final int S1MME_OVERLOAD_STOP = 27;
		public static final int S1MME_IDENTITY_ACQUISITION = 28;
		public static final int S1MME_AUTHENTICAITON = 29;
		public static final int S1MME_SECURITY = 30;

		/* s6a 流程编码 */

		public static final int S6A_UPDATE_LOCATION = 1;
		public static final int S6A_CANCEL_LOCATION = 2;
		public static final int S6A_PURGE_UE = 3;
		public static final int S6A_INSERT_SUBSCRIBER_DATA = 4;
		public static final int S6A_DELETE_SUBSCRIBER_DATA = 5;
		public static final int S6A_AUTHENTICATION_INFORMATION = 6;
		public static final int S6A_RESET = 7;
		public static final int S6A_NOTIFICATION = 8;

		/* S10S11 流程编码 */

		public static final int S10S11_CREATE_SESSION = 1;
		public static final int S10S11_MODIFY_BEARER = 2;
		public static final int S10S11_DELETE_SESSION = 3;
		public static final int S10S11_MODIFY_BEARER_COMMAND = 4;
		public static final int S10S11_DELETE_BEARER_COMMAND = 5;
		public static final int S10S11_BEARER_RESOURCE_COMMAND = 6;
		public static final int S10S11_CREATE_BEARER = 7;
		public static final int S10S11_UPDATE_BEARER = 8;
		public static final int S10S11_DELETE_BEARER = 9;
		public static final int S10S11_RELEASE_ACCESS_BEARERS = 10;
		public static final int S10S11_MODIFY_ACCESS_BEARERS = 11;
		public static final int S10S11_ECHO_REQUEST = 12;
		public static final int S10S11_VERSION_NOT_SUPPORTED_INDICATION = 13;
		public static final int S10S11_CHANGE_NOTIFICATION = 14;
		public static final int S10S11_DOWNLINK_DATA_NOTIFICATION_FAILURE_INDICATION = 15;
		public static final int S10S11_TRACE_SESSION_ACTIVATION = 16;
		public static final int S10S11_TRACE_SESSION_DEACTIVATION = 17;
		public static final int S10S11_STOP_PAGING_INDICATION = 18;
		public static final int S10S11_DELETE_PDN_CONNECTION_SET = 19;
		public static final int S10S11_PGW_DOWNLINK_TRIGGERING_NOTIFICATION = 20;
		public static final int S10S11_IDENTIFICATION_REQUEST = 21;
		public static final int S10S11_CONTEXT_REQUEST = 22;
		public static final int S10S11_FORWARD_RELOCATION_REQUEST = 23;
		public static final int S10S11_FORWARD_RELOCATION_COMPLETE_NOTIFICATION = 24;
		public static final int S10S11_FORWARD_ACCESS_CONTEXT_NOTIFICATION = 25;
		public static final int S10S11_RELOCATION_CANCEL_REQUEST = 26;
		public static final int S10S11_CONFIGURATION_TRANSFER_TUNNEL = 27;
		public static final int S10S11_SUSPEND_NOTIFICATION = 28;
		public static final int S10S11_CREATE_FORWARDING_TUNNEL = 29;
		public static final int S10S11_RESUME_NOTIFICATION = 30;
		public static final int S10S11_CREATE_INDIRECT_DATA_FORWARDING_TUNNEL = 31;
		public static final int S10S11_DELETE_INDIRECT_DATA_FORWARDING_TUNNEL = 32;
		public static final int S10S11_DOWNLINK_DATA_NOTIFICATION = 33;
		public static final int S10S11_PGW_RESTART_NOTIFICATION = 34;

		/* S5/S8-C 接口流程 */

		public static final int S5S8C_ECHO_REQUEST = 1;
		public static final int S5S8C_VERSION_NOT_SUPPORTED_INDICATION = 2;
		public static final int S5S8C_CREATE_SESSION = 3;
		public static final int S5S8C_MODIFY_BEARER = 4;
		public static final int S5S8C_DELETE_SESSION = 5;
		public static final int S5S8C_CHANGE_NOTIFICATION = 6;
		public static final int S5S8C_RESUME_NOTIFICATION = 7;
		public static final int S5S8C_MODIFY_BEARER_COMMAND = 8;
		public static final int S5S8C_MODIFY_BEARER_FAILURE_INDICATION = 9;
		public static final int S5S8C_DELETE_BEARER_COMMAND = 10;
		public static final int S5S8C_DELETE_BEARER_FAILURE_INDICATION = 11;
		public static final int S5S8C_BEARER_RESOURCE_COMMAND = 12;
		public static final int S5S8C_BEARER_RESOURCE_FAILURE_INDICATION = 13;
		public static final int S5S8C_TRACE_SESSION_ACTIVATION = 14;
		public static final int S5S8C_TRACE_SESSION_DEACTIVATION = 15;
		public static final int S5S8C_CREATE_BEARER = 16;
		public static final int S5S8C_UPDATE_BEARER = 17;
		public static final int S5S8C_DELETE_BEARER = 18;
		public static final int S5S8C_DELETE_PDN_CONNECTION_SET = 19;
		public static final int S5S8C_SUSPEND_NOTIFICATION = 20;
		public static final int S5S8C_UPDATE_PDN_CONNECTION_SET = 21;

		/* SGs 接口流程 */

		public static final int SGSAP_PAGING = 1;
		public static final int SGSAP_SERVICE_REQUEST = 2;
		public static final int SGSAP_DOWNLINK_UNITDATA = 3;
		public static final int SGSAP_UPLINK_UNITDATA = 4;
		public static final int SGSAP_LOCATION_UPDATE = 5;
		public static final int SGSAP_TMSI_REALLOCATION = 6;
		public static final int SGSAP_ALERT = 7;
		public static final int SGSAP_UE_ACTIVITY_INDICATION = 8;
		public static final int SGSAP_EPS_DETACH = 9;
		public static final int SGSAP_IMSI_DETACH = 10;
		public static final int SGSAP_RESET = 11;
		public static final int SGSAP_SERVICE_ABORT = 12;
		public static final int SGSAP_MM_INFORMATION = 13;
		public static final int SGSAP_RELEASE = 14;
		public static final int SGSAP_STATUS = 15;
		public static final int SGSAP_UE_UNREACHABLE = 16;

		/* Gn-C 接口流程 */

		public static final int ROUTING_AREA_UPDATE_4G_2G3G = 1;
		public static final int GNGP_SGSN_TO_MME_TRACKING_AREA_UPDATE_2G3G_4G = 2;
		public static final int EUTRAN_INITIAL_ATTACH = 3;
	}

	/**
	 * 移动版LTE XDR接口
	 * 
	 */
	public static enum XDR {
		UU, X2, UE_MR, CELL_MR, S1MME, S6A, S11, S10, SGS, S5S8, S1U, GNC, UNKNOW
	}

	/**
	 * 合成XDR类型
	 * 
	 */
	public static class NotifyXDRType {
		public static final int SINGLE = 2; // 单接口XDR
		public static final int COMP = 1; // 合成XDR
	}

	/**
	 * 数据源
	 */
	public static class DataSource {
		public static final int NONE = 0;
		public static final int SDTP = 1;
		public static final int KAFKA = 2;
	}

}

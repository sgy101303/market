package com.example.market.util;

import kr.sharenshare.keylitadmin.controller.payload.SendEmailPayload;
import kr.sharenshare.keylitadmin.domain.enums.SendEmailType;

public class EmailFormat {

    /**
     * 발신하는 메일 type에 따라 제목 설정
     *
     * @param type
     * @return
     */
    public static String typeOfSubject(SendEmailType type) {
        String subject = "[ KEYLIT ] ";
        String appendSubject = "";

        if (type == SendEmailType.ADD_COMPANY) {
            appendSubject = "관리자에 의해 회원가입 되었습니다.";
        }
        else if (type == SendEmailType.COMPANY_APPROVAL) {
            appendSubject = "요청하셨던 회원가입이 승인되었습니다.";
        }
        else if (type == SendEmailType.COMPANY_DECLINE) {
            appendSubject = "요청하신 회원가입이 거절되었습니다.";
        }
        else if (type == SendEmailType.FIND_PASSWORD) {
            appendSubject = "임시 비밀번호 발급 안내";
        }
        return subject + appendSubject;
    }

    /**
     * 발신하는 메일 type에 따라 내용 설정
     *
     * @param sendEmailPayload
     * @return email content
     */
    public static Object sendContent(SendEmailPayload sendEmailPayload) {
        String content = "";

        if (sendEmailPayload.getType() == SendEmailType.ADD_COMPANY) {
            content += addCompanyContent(sendEmailPayload);
        }
        else if (sendEmailPayload.getType() == SendEmailType.COMPANY_APPROVAL) {
            content += companyApprovalContent(sendEmailPayload);
        }
        else if (sendEmailPayload.getType() == SendEmailType.COMPANY_DECLINE) {
            content += companyDeclineContent(sendEmailPayload);
        }
        else if (sendEmailPayload.getType() == SendEmailType.FIND_PASSWORD) {
            content += findPasswordContent(sendEmailPayload);
        }
        return content;
    }

    // 관리자가 회사 추가 할 경우 email content
    private static String addCompanyContent(SendEmailPayload sendEmailPayload) {
        // region [ addCompany html ]
        String content = "";
        content += "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;background-color:#f8f8f9;letter-spacing:-1px\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\">\n" +
                "\t\t\t\t<!-- 아웃룩용 max-width 핵 --><!--[if (gte mso 9)|(IE)]>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"595\">\n" +
                "\t\t\t\t<![endif]-->\n" +
                "<div style=\"max-width: 595px; margin: 0px auto; font-family: 돋움; font-size: 12pt; line-height: normal;\">\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px auto; background-color: rgb(255, 255, 255); text-size-adjust: 100%; text-align: left; height: 1310px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"30\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 42px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"margin: 0px; padding: 0px; height: 10px;\">\n" +
                "\t\t\t\t<br>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"11\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 92px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 28px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(66, 66, 64); line-height: 34px; vertical-align: top; height: 15px;\">\n" +
                "\t\t\t\t<span style=\"color: rgb(55, 114, 209); font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 21pt; line-height: 34px; margin-top: 0px; margin-bottom: 0px;\">\n" +
                "KEYLIT</span><br>관리자 페이지 회원가입 안내\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"1\" style=\"background:#e5e5e5\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"23\" style=\"height: 523px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"24\" style=\"height: 523px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 356px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 208.672px;\">\n" +
                "\t\t\t\t\n" +
                " 안녕하세요, 쉐어앤쉐어 입니다.<br><br>관리자 페이지 회원 가입이 완료되었습니다.&nbsp;<br><br>아래의 이메일과 임시 비밀번호 확인하여 로그인 해주시기 바랍니다.<br><br>임시 비밀번호로 로그인 후에는 설정에&nbsp;<br><br>'비밀번호 변경'을 하시면 바뀐 비밀번호로 이용 가능합니다.<br><br>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t\n" +
                "[ 계정 정보 ]\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">이메일 : " + sendEmailPayload.getAccountEmail() +
                "&nbsp;</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">임시 비밀번호 : " + sendEmailPayload.getTemporaryPassword() +
                "&nbsp;</p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "<table style=\"table-layout: fixed;width:100%;background:#3772d1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"56\" style=\"line-height:56px;text-align:center\">\n" +
                "\t\t\t\t<a href=\"http://admin.keylit.sharenshare.kr/login\" style=\"display:block;font-size:18px;color:#fff;text-decoration:none;font-family:'나눔고딕',NanumGothic,'맑은고딕',Malgun Gothic,'돋움',Dotum,Helvetica,'Apple SD Gothic Neo',Sans-serif;\" rel=\"noreferrer noopener\" target=\"_blank\">KEYLIT 로그인 바로가기</a> \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\n" +
                "\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\" colspan=\"3\" style=\"height: 10px;\">\n" +
                "\t\t\t\t\n" +
                "<div style=\"display: inline-block; width: 278px; max-width: 100%; vertical-align: top; font-family: 돋움; font-size: 12pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;\"><br></div>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"40\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 감사합니다.</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 쉐어앤쉐어 드림</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!-- footer-->\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" style=\"padding: 26px 21px 13px; background: rgb(229, 229, 229); font-size: 12px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(105, 105, 105); line-height: 17px;\">\n" +
                "\t\t\t\t\n" +
                "<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"word-break: break-word; color: rgb(34, 34, 34); font-family: 나눔고딕, NanumGothic, 돋움, Dotum, 굴림, Gulim, sans-serif, &quot;Meiryo UI&quot;; font-size: 12px; letter-spacing: normal; table-layout: fixed; overflow-wrap: break-word; max-width: 500px; width: 500px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px 0px 15px; margin: 0px; color: rgb(85, 85, 85); height: 68px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211);\">\n" +
                "\t\t\t\t<a href=\"https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&amp;fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FUUpzm%2Fbtq1caBpAUi%2Fab9kU2JFUwkbz98EgMKlWk%2Fimg.png\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(34, 34, 34); display: block;\"><img src=\"https://image.signature.email/images/606052ffafd62.png\" width=\"200\" height=\"68\" border=\"0\" alt=\"쉐어앤쉐어\" loading=\"lazy\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; display: block;\"></a>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">Tel&nbsp;&nbsp;</span><a href=\"tel:041-910-1133\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">041-910-1133</a><span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">&nbsp; &nbsp;Fax&nbsp;&nbsp;</span><a href=\"tel:0504-240-8596\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">0504-240-8596</a>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">본사</span>&nbsp;31460 충남 아산시 탕정면 선문로221번길 70, 선문대학교 산학협력관 413B호\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">기업부설연구소</span>&nbsp;31470 충남 아산시 배방읍 희망로46번길 45-7, 용주프라자 4층\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 13px; line-height: 18px; vertical-align: baseline; letter-spacing: 2px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\"><a href=\"https://www.sharenshare.kr/\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">www.sharenshare.kr</a></span>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t\n" +
                "--------------------------------\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: inherit; font-stretch: inherit; font-size: 11px; line-height: 18px; vertical-align: baseline; color: rgb(153, 153, 153); font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">This email and any files transmitted with it are confidential and intended solely for the use of the individual or entity to whom they are addressed. If you have received this email in error please notify the system manager. This message contains confidential information and is intended only for the individual named. If you are not the named addressee you should not disseminate, distribute or copy this e-mail. Please notify the sender immediately by e-mail if you have received this e-mail by mistake and delete this e-mail from your system. If you are not the intended recipient you are notified that disclosing, copying, distributing or taking any action in reliance on the contents of this information is strictly prohibited.<br><br></span>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!--// footer-->\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "</div><!--[if mso]>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "</table>\n" +
                "<![endif]-->\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>";
        // endregion
        return content;

    }

    // 회사 승인 일 경우 email content
    private static String companyApprovalContent(SendEmailPayload sendEmailPayload) {
        // region [ addCompany html ]
        String content = "";
        content += "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;background-color:#f8f8f9;letter-spacing:-1px\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\">\n" +
                "\t\t\t\t<!-- 아웃룩용 max-width 핵 --><!--[if (gte mso 9)|(IE)]>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"595\">\n" +
                "\t\t\t\t<![endif]-->\n" +
                "<div style=\"max-width: 595px; margin: 0px auto; font-family: 돋움; font-size: 12pt; line-height: normal;\">\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px auto; background-color: rgb(255, 255, 255); text-size-adjust: 100%; text-align: left; height: 1169px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"30\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 42px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"margin:0;padding:0\">\n" +
                "\t\t\t\t<br>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"11\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;margin:0;padding:0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 28px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(66, 66, 64); line-height: 34px; vertical-align: top;\">\n" +
                "\t\t\t\t<span style=\"color: rgb(55, 114, 209); font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 21pt; line-height: 34px; margin-top: 0px; margin-bottom: 0px;\">\n" +
                "KEYLIT</span><br>관리자 페이지 회원가입 승인 안내\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"1\" style=\"background:#e5e5e5\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"25\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"23\" style=\"height: 466px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"24\" style=\"height: 466px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 369.141px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                " 안녕하세요, 쉐어앤쉐어 입니다.<br><br>관리자 페이지 회원 가입 승인이 완료되었습니다.&nbsp;<br><br>회원가입 하셨던 이메일과 비밀번호로 정상 이용 가능합니다.<br>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "[ 계정 정보 ]\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">이메일 : " + sendEmailPayload.getAccountEmail() +
                "&nbsp;</p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "<table style=\"table-layout: fixed;width:100%;background:#3772d1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"56\" style=\"line-height:56px;text-align:center\">\n" +
                "\t\t\t\t<a href=\"http://admin.keylit.sharenshare.kr/login\" style=\"display:block;font-size:18px;color:#fff;text-decoration:none;font-family:'나눔고딕',NanumGothic,'맑은고딕',Malgun Gothic,'돋움',Dotum,Helvetica,'Apple SD Gothic Neo',Sans-serif;\" rel=\"noreferrer noopener\" target=\"_blank\">KEYLIT 로그인 바로가기</a> \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\" colspan=\"3\" style=\"height: 10px;\">\n" +
                "\t\t\t\t\n" +
                "<div style=\"display: inline-block; width: 278px; max-width: 100%; vertical-align: top; font-family: 돋움; font-size: 12pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;\"><br></div>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"40\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 감사합니다.</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 쉐어앤쉐어 드림</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!-- footer-->\n" +
                "      \n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" style=\"padding: 26px 21px 13px; background: rgb(229, 229, 229); font-size: 12px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(105, 105, 105); line-height: 17px;\">\n" +
                "\t\t\t\t\n" +
                "<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"word-break: break-word; color: rgb(34, 34, 34); font-family: 나눔고딕, NanumGothic, 돋움, Dotum, 굴림, Gulim, sans-serif, &quot;Meiryo UI&quot;; font-size: 12px; letter-spacing: normal; table-layout: fixed; overflow-wrap: break-word; max-width: 500px; width: 500px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px 0px 15px; margin: 0px; color: rgb(85, 85, 85); height: 68px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211);\">\n" +
                "\t\t\t\t<a href=\"https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&amp;fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FUUpzm%2Fbtq1caBpAUi%2Fab9kU2JFUwkbz98EgMKlWk%2Fimg.png\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(34, 34, 34); display: block;\"><img src=\"https://image.signature.email/images/606052ffafd62.png\" width=\"200\" height=\"68\" border=\"0\" alt=\"쉐어앤쉐어\" loading=\"lazy\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; display: block;\"></a>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">Tel&nbsp;&nbsp;</span><a href=\"tel:041-910-1133\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">041-910-1133</a><span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">&nbsp; &nbsp;Fax&nbsp;&nbsp;</span><a href=\"tel:0504-240-8596\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">0504-240-8596</a>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">본사</span>&nbsp;31460 충남 아산시 탕정면 선문로221번길 70, 선문대학교 산학협력관 413B호\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">기업부설연구소</span>&nbsp;31470 충남 아산시 배방읍 희망로46번길 45-7, 용주프라자 4층\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 13px; line-height: 18px; vertical-align: baseline; letter-spacing: 2px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\"><a href=\"https://www.sharenshare.kr/\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">www.sharenshare.kr</a></span>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "--------------------------------\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: inherit; font-stretch: inherit; font-size: 11px; line-height: 18px; vertical-align: baseline; color: rgb(153, 153, 153); font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">This email and any files transmitted with it are confidential and intended solely for the use of the individual or entity to whom they are addressed. If you have received this email in error please notify the system manager. This message contains confidential information and is intended only for the individual named. If you are not the named addressee you should not disseminate, distribute or copy this e-mail. Please notify the sender immediately by e-mail if you have received this e-mail by mistake and delete this e-mail from your system. If you are not the intended recipient you are notified that disclosing, copying, distributing or taking any action in reliance on the contents of this information is strictly prohibited.<br><br></span>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!--// footer-->\n" +
                "   \n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "</div><!--[if mso]>\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "</table>\n" +
                "<![endif]-->\n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>";
        // endregion
        return content;

    }

    // 회사 거절 일 경우 email content
    private static String companyDeclineContent(SendEmailPayload sendEmailPayload) {
        // region [ addCompany html ]
        String content = "";
        content += "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;background-color:#f8f8f9;letter-spacing:-1px\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\">\n" +
                "\t\t\t\t<!-- 아웃룩용 max-width 핵 --><!--[if (gte mso 9)|(IE)]>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"595\">\n" +
                "\t\t\t\t<![endif]-->\n" +
                "<div style=\"max-width: 595px; margin: 0px auto; font-family: 돋움; font-size: 12pt; line-height: normal;\">\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px auto; background-color: rgb(255, 255, 255); text-size-adjust: 100%; text-align: left; height: 1169px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"30\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 42px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"margin:0;padding:0\">\n" +
                "\t\t\t\t<br>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"11\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;margin:0;padding:0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 28px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(66, 66, 64); line-height: 34px; vertical-align: top;\">\n" +
                "\t\t\t\t<span style=\"color: rgb(55, 114, 209); font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 21pt; line-height: 34px; margin-top: 0px; margin-bottom: 0px;\">\n" +
                "KEYLIT</span><br>관리자 페이지 회원가입 거절&nbsp;안내\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"1\" style=\"background:#e5e5e5\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"25\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"23\" style=\"height: 466px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"24\" style=\"height: 466px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 369.141px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "            \n" +
                " 안녕하세요, 쉐어앤쉐어 입니다.<br><br>관리자 페이지 회원 가입이 거절되었습니다.&nbsp;<br><br>거절 사유를 확인하신 후&nbsp;회원가입 하셨던 이메일과 비밀번호로 로그인 하시어<br><br>재제출 해주시면 다시 검토하도록 하겠습니다.\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "            \n" +
                "[ 계정 정보 ]\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">이메일 : " + sendEmailPayload.getAccountEmail() +
                "&nbsp;</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">사유 : " + sendEmailPayload.getDeclineReason() +
                "</p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "<table style=\"table-layout: fixed;width:100%;background:#3772d1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"56\" style=\"line-height:56px;text-align:center\">\n" +
                "\t\t\t\t<a href=\"http://admin.keylit.sharenshare.kr/login\" style=\"display:block;font-size:18px;color:#fff;text-decoration:none;font-family:'나눔고딕',NanumGothic,'맑은고딕',Malgun Gothic,'돋움',Dotum,Helvetica,'Apple SD Gothic Neo',Sans-serif;\" rel=\"noreferrer noopener\" target=\"_blank\">KEYLIT 로그인 바로가기</a> \n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\" colspan=\"3\" style=\"height: 10px;\">\n" +
                "\t\t\t\t\n" +
                "<div style=\"display: inline-block; width: 278px; max-width: 100%; vertical-align: top; font-family: 돋움; font-size: 12pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;\"><br></div>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"40\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 감사합니다.</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 쉐어앤쉐어 드림</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!-- footer-->\n" +
                "      \n" +
                "      \n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" style=\"padding: 26px 21px 13px; background: rgb(229, 229, 229); font-size: 12px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(105, 105, 105); line-height: 17px;\">\n" +
                "\t\t\t\t\n" +
                "<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"word-break: break-word; color: rgb(34, 34, 34); font-family: 나눔고딕, NanumGothic, 돋움, Dotum, 굴림, Gulim, sans-serif, &quot;Meiryo UI&quot;; font-size: 12px; letter-spacing: normal; table-layout: fixed; overflow-wrap: break-word; max-width: 500px; width: 500px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px 0px 15px; margin: 0px; color: rgb(85, 85, 85); height: 68px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211);\">\n" +
                "\t\t\t\t<a href=\"https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&amp;fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FUUpzm%2Fbtq1caBpAUi%2Fab9kU2JFUwkbz98EgMKlWk%2Fimg.png\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(34, 34, 34); display: block;\"><img src=\"https://image.signature.email/images/606052ffafd62.png\" width=\"200\" height=\"68\" border=\"0\" alt=\"쉐어앤쉐어\" loading=\"lazy\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; display: block;\"></a>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">Tel&nbsp;&nbsp;</span><a href=\"tel:041-910-1133\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">041-910-1133</a><span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">&nbsp; &nbsp;Fax&nbsp;&nbsp;</span><a href=\"tel:0504-240-8596\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">0504-240-8596</a>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">본사</span>&nbsp;31460 충남 아산시 탕정면 선문로221번길 70, 선문대학교 산학협력관 413B호\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">기업부설연구소</span>&nbsp;31470 충남 아산시 배방읍 희망로46번길 45-7, 용주프라자 4층\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 13px; line-height: 18px; vertical-align: baseline; letter-spacing: 2px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\"><a href=\"https://www.sharenshare.kr/\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">www.sharenshare.kr</a></span>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "            \n" +
                "--------------------------------\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: inherit; font-stretch: inherit; font-size: 11px; line-height: 18px; vertical-align: baseline; color: rgb(153, 153, 153); font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">This email and any files transmitted with it are confidential and intended solely for the use of the individual or entity to whom they are addressed. If you have received this email in error please notify the system manager. This message contains confidential information and is intended only for the individual named. If you are not the named addressee you should not disseminate, distribute or copy this e-mail. Please notify the sender immediately by e-mail if you have received this e-mail by mistake and delete this e-mail from your system. If you are not the intended recipient you are notified that disclosing, copying, distributing or taking any action in reliance on the contents of this information is strictly prohibited.<br><br></span>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!--// footer-->\n" +
                "   \n" +
                "   \n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "</div><!--[if mso]>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "</table>\n" +
                "<![endif]-->\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>";
        // endregion
        return content;

    }

    // 임시 비밀번호 발급 일 경우 email content
    private static String findPasswordContent(SendEmailPayload sendEmailPayload) {
        // region [ addCompany html ]
        String content = "";
        content += "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;background-color:#f8f8f9;letter-spacing:-1px\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\">\n" +
                "\t\t\t\t<!-- 아웃룩용 max-width 핵 --><!--[if (gte mso 9)|(IE)]>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"595\">\n" +
                "\t\t\t\t<![endif]-->\n" +
                "<div style=\"max-width: 595px; margin: 0px auto; font-family: 돋움; font-size: 12pt; line-height: normal;\">\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px auto; background-color: rgb(255, 255, 255); text-size-adjust: 100%; text-align: left; height: 1169px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"30\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 42px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"margin:0;padding:0\">\n" +
                "\t\t\t\t<br>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"11\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"23\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;margin:0;padding:0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 28px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(66, 66, 64); line-height: 34px; vertical-align: top;\">\n" +
                "\t\t\t\t<span style=\"color: rgb(55, 114, 209); font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 21pt; line-height: 34px; margin-top: 0px; margin-bottom: 0px;\">\n" +
                "KEYLIT</span><br>관리자 페이지 임시 비밀번호 발급 안내\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"24\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"1\" style=\"background:#e5e5e5\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"25\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"23\" style=\"height: 466px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td rowspan=\"3\" width=\"24\" style=\"height: 466px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>\n" +
                "\t\t\t\t\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; margin: 0px; padding: 0px; height: 369.141px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "            \n" +
                " 안녕하세요, 쉐어앤쉐어 입니다.<br><br>KEYLIT 관리자 페이지 임시 비밀번호 발급이 완료되었습니다.&nbsp;<br><br>회원가입 하셨던 이메일과 임시 비밀번호로 로그인 해주시기 바랍니다.<br><br>임시 비밀번호 로그인 후에는 우측 상단의 비밀번호 변경을 통해<br><br>비밀번호를 변경하신 뒤 사용하실 수 있습니다.\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"24\" style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 156.141px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "            \n" +
                "[ 계정 정보 ]\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"color: rgb(51, 51, 51); font-size: 15px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-weight: 600; height: 16px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">임시 비밀번호 : " +  sendEmailPayload.getTemporaryPassword() +"&nbsp;</p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"29\" style=\"\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td height=\"25\" style=\"height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p style=\"font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; font-size: 11pt; line-height: 22px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"font-size: 14px; line-height: 24px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(51, 51, 51); height: 10px;\">\n" +
                "\t\t\t\t<p><br></p>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "<table style=\"table-layout: fixed;width:100%;background:#3772d1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"56\" style=\"line-height:56px;text-align:center\">\n" +
                "\t\t\t\t<a href=\"http://admin.keylit.sharenshare.kr/login\" style=\"display:block;font-size:18px;color:#fff;text-decoration:none;font-family:'나눔고딕',NanumGothic,'맑은고딕',Malgun Gothic,'돋움',Dotum,Helvetica,'Apple SD Gothic Neo',Sans-serif;\" rel=\"noreferrer noopener\" target=\"_blank\">KEYLIT 로그인 바로가기</a> \n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\" colspan=\"3\" style=\"height: 10px;\">\n" +
                "\t\t\t\t\n" +
                "<div style=\"display: inline-block; width: 278px; max-width: 100%; vertical-align: top; font-family: 돋움; font-size: 12pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;\"><br></div>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" height=\"40\" style=\"\">\n" +
                "\t\t\t\t<p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 감사합니다.</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\">&nbsp; &nbsp; 쉐어앤쉐어 드림</p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p><p style=\"font-family: 돋움; font-size: 12pt; line-height: 24px; margin-top: 0px; margin-bottom: 0px;\"><br></p>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!-- footer-->\n" +
                "      \n" +
                "      \n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" style=\"padding: 26px 21px 13px; background: rgb(229, 229, 229); font-size: 12px; font-family: 나눔고딕, NanumGothic, 맑은고딕, &quot;Malgun Gothic&quot;, 돋움, Dotum, Helvetica, &quot;Apple SD Gothic Neo&quot;, sans-serif; color: rgb(105, 105, 105); line-height: 17px;\">\n" +
                "\t\t\t\t\n" +
                "<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"word-break: break-word; color: rgb(34, 34, 34); font-family: 나눔고딕, NanumGothic, 돋움, Dotum, 굴림, Gulim, sans-serif, &quot;Meiryo UI&quot;; font-size: 12px; letter-spacing: normal; table-layout: fixed; overflow-wrap: break-word; max-width: 500px; width: 500px;\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px 0px 15px; margin: 0px; color: rgb(85, 85, 85); height: 68px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211);\">\n" +
                "\t\t\t\t<a href=\"https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&amp;fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FUUpzm%2Fbtq1caBpAUi%2Fab9kU2JFUwkbz98EgMKlWk%2Fimg.png\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(34, 34, 34); display: block;\"><img src=\"https://image.signature.email/images/606052ffafd62.png\" width=\"200\" height=\"68\" border=\"0\" alt=\"쉐어앤쉐어\" loading=\"lazy\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; display: block;\"></a>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">Tel&nbsp;&nbsp;</span><a href=\"tel:041-910-1133\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">041-910-1133</a><span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">&nbsp; &nbsp;Fax&nbsp;&nbsp;</span><a href=\"tel:0504-240-8596\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">0504-240-8596</a>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">본사</span>&nbsp;31460 충남 아산시 탕정면 선문로221번길 70, 선문대학교 산학협력관 413B호\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 9pt; line-height: 18px; vertical-align: baseline; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">기업부설연구소</span>&nbsp;31470 충남 아산시 배방읍 희망로46번길 45-7, 용주프라자 4층\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: 13px; line-height: 18px; vertical-align: baseline; letter-spacing: 2px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\"><a href=\"https://www.sharenshare.kr/\" target=\"_blank\" rel=\"noreferrer noopener\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font: inherit; vertical-align: baseline; text-decoration-line: none; color: rgb(245, 158, 11);\">www.sharenshare.kr</a></span>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t\n" +
                "            \n" +
                "            \n" +
                "--------------------------------\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"vertical-align: middle; word-break: normal; padding: 0px; margin: 0px; color: rgb(85, 85, 85); line-height: 18px; font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif; border-width: 1px; border-style: dashed; border-color: rgb(211, 211, 211); height: 0px;\">\n" +
                "\t\t\t\t<span style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-style: inherit; font-variant: inherit; font-weight: inherit; font-stretch: inherit; font-size: 11px; line-height: 18px; vertical-align: baseline; color: rgb(153, 153, 153); font-family: NanumGothic, 나눔고딕, &quot;Malgun Gothic&quot;, &quot;맑은 고딕&quot;, sans-serif;\">This email and any files transmitted with it are confidential and intended solely for the use of the individual or entity to whom they are addressed. If you have received this email in error please notify the system manager. This message contains confidential information and is intended only for the individual named. If you are not the named addressee you should not disseminate, distribute or copy this e-mail. Please notify the sender immediately by e-mail if you have received this e-mail by mistake and delete this e-mail from your system. If you are not the intended recipient you are notified that disclosing, copying, distributing or taking any action in reliance on the contents of this information is strictly prohibited.<br><br></span>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr><!--// footer-->\n" +
                "   \n" +
                "   \n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "</div><!--[if mso]>\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "</table>\n" +
                "<![endif]-->\n" +
                "         \n" +
                "         \n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>";
        // endregion
        return content;

    }

}
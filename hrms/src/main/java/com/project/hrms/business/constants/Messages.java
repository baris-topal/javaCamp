package com.project.hrms.business.constants;

public class Messages {

	public static String ERROR_FIELD_IS_BLANK = "Boş alan mevcut.";
	public static String ERROR_EMAIL_ALREADY_EXISTS = "Girilen email kayıtlı.";
	public static String SUCCESS_DATA_ADDED = "Ekleme işlemi başarılı.";
	public static String SUCCESS_DATA_LISTED = "Listeleme işlemi başarılı.";

	// User
	public static String USER_ERROR_MATCH_PASSWORD = "Girilen şifreler eşleşmiyor.";

	// Job Position
	public static String JOB_POSITION_ERROR_ALREADY_EXISTS = "Girilen pozisyon mevcut.";

	// Job Seeker
	public static String JOB_SEEKER_ERROR_IDENTITY_NUMBER_ALREADY_EXISTS = "Girilen kimlik numarası kayıtlı.";
	public static String JOB_SEEKER_ERROR_LENGTH_IDENTITY_NUMBER = "Geçersiz kimlik numarası";

	// Employer
	public static String EMPLOYER_ERROR_MATCH_EMAIL_WEB_SITE = "Domainler eşleşmiyor.";
}

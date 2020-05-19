package pages;

public class PageConstants 
{
	public final static String LINK_HOTEL = "//ul[@class='mainLinks']//a[contains(@href,'hotels')]";
	public final static String RADIO_INDIA = "//div[@class='SearchBlockUIstyles__RadioButtonWrap-fity7j-4 gNpxzw'][1]//input";
	public final static String RADIO_INTRNTNLS = "//div[@class='SearchBlockUIstyles__RadioButtonWrap-fity7j-4 gNpxzw'][2]//input";
	public final static String TXT_WHERE = "downshift-1-input";
	public final static String DRP_SELCITY1 = "//ul[contains(@class,'HomePageAutosuggeststyles__SearchMenuStyles')]/li[1]";
	public final static String BOX_CHKIN = "//div[text()='Check-in Date']//following::div[1]";
	public final static String BOX_CHKOUT = "//div[text()='Check-out Date']//following::div[1]";
	public final static String LBL_MNTH = "//p[starts-with(@class, 'dcalendarstyles__MonthNamePara')]";
	public final static String ARR_RIGHT = "//div[@class='dcalendarstyles__MonthChangeRightArrowDiv-r2jz2t-16 eVCvYn']";
	public final static String BOX_GSTNRM = "//input[contains(@class,'CitySearchInput')]";
	public final static String VLU_RMCNT = "//span[text()='Rooms']//following-sibling::div/span[@class='PaxWidgetstyles__ContentActionValueWrapperSpan-gv3w6r-6 gpOosi']";
	public final static String SGN_PLUS_RM = "//span[text()='Rooms']//following-sibling::div/span[text()='+']";
	public final static String SGN_MNS_RM = "//span[text()='Rooms']//following-sibling::div/span[text()='-']";
	public final static String VLU_GSTCNT = "//span[text()='Adults']//following-sibling::div/span[@class='PaxWidgetstyles__ContentActionValueWrapperSpan-gv3w6r-6 gpOosi']";
	public final static String SGN_PLUS_GST = "//span[text()='Adults']//following-sibling::div/span[text()='+']";
	public final static String SGN_MNS_GST = "//span[text()='Adults']//following-sibling::div/span[text()='-']";
	public final static String BTN_DONE="//button[@class='PaxWidgetstyles__ButtonWrapper-gv3w6r-9 driPxZ']";
	public final static String BTN_SEARCH_HOTELS="//button[@class='SearchBlockUIstyles__SearchButtonAutoSuggest-fity7j-12 kGmYkx']";
	public final static String LBL_HOTELNAME = "//span[contains(@class,'HotelNameText')]";
	public final static String BTN_BACKTOTOP = "//span[contains(@class,'BackToTopCard__TextSpan')]";
	public final static String IMG_HOTEL = "//div[@class='HotelCardImageGallerystyles__MainImageWrapperDivStyle-r3dzqu-1 hndaad']/img";
	public final static String BNR_LOGIN = "//div[contains(@class,'SignUpBannerstyles__SignUpBannerContainer')]";
	public final static String CHK_PAYATHOTEL ="//div[@class='CheckBoxList__TextCenteredDiv-sc-5k7440-5 hafBgd']/span[text()='Pay At Hotel']";
	public final static String CHK_PRICERANGE2 ="//div[@class='CheckBoxList__CheckboxListWrapperDiv-sc-5k7440-0 iVbvPd'][2]//div[3]";
	public final static String CHK_RATING4 ="//div[@class='CheckBoxList__CheckboxListWrapperDiv-sc-5k7440-0 iVbvPd'][3]/div[2]";
	public final static String LBL_PRICE ="//span[contains(@class,'HotelCardstyles__CurrentPrice')]";
	public final static String LBL_RATING ="//span[contains(@class,'ReviewAndRatingsstyles__AverageReviewText')]";
	
	//Hotel detail page
	public final static String BTN_VWRMOPTNS = "//button[contains(@class,'ViewRoomOptionsButton')]";
	public final static String BTN_SLCTRM = "//button[contains(@class,'RoomFlavor__ButtonWrapper')]";
	public final static String LBL_RMOPTS = "//div[contains(@class,'RoomFlavor__RoomHeadingContainer')]";
	public final static String LNK_LOCATION = "//a[@href='#location']";
	public final static String IMG_LOCATION = "//img[@src='//maps.google.com/mapfiles/kml/paddle/red-stars.png']";
	public final static String LNK_GUESTRVW = "//a[@href='#location']";
	public final static String DIV_GUESTRVW = "//div[contains(@class,'ReviewByUserWrapperDiv')]";
	public final static String LNK_QUESANDANSWR = "//a[@href='#QnA']";
	public final static String DIV_QUESANDANSWR = "//div[contains(@class,'QnaAutosuggeststyles__Wrapper')]";
	public final static String LNK_HOTELPOLICIES = "//a[@href='#hotel-policies']";
	public final static String DIV_HOTELPOLICIES = "//ul[contains(@class,'Policy__PolicyListBlock')]";
	
	//Review booking page
	public final static String LBL_RVWHTLNM = "//p[contains(@class,'HotelDetailsWrap__ReviewHotelNamePara')]";
	public final static String LBL_RVWRMTYP = "//p[contains(@class,'RoomType__RoomTypeTxtPara')]";
	public final static String LBL_RVWCHKININFO = "//p[contains(@class,'CheckInWrapPara')]";
	public final static String TXT_FIRSTNAME = "//input[@placeholder='Enter First Name']";
	public final static String TXT_LASTNAME = "//input[@placeholder='Enter Last Name']";
	public final static String TXT_EMAIL = "//input[@placeholder='Enter Email Address']";
	public final static String TXT_MOBNUM = "//input[@placeholder='Enter Phone Number']";
	public final static String SEL_EXPCHKINTIME = "//select[@class='PersonalProfile__ExpectedCheckinDropdown-sc-1r9ak8b-16 cktZpD']";
	public final static String ARR_SPLRQST = "//div[contains(@class,'SpecialRequestBlock__CircularDiv')]";
	public final static String TXT_SPLRQST = "//input[@placeholder='Enter Special Request']";
	public final static String BTN_PYMNTOPTNS = "//button[contains(@class,'GuestDetailBlock__CustomButton')]";
	
	//Payment page
	public final static String TXT_CARDNUM = "//div[@class='paymentContent']//input[@placeholder='Card Number']";
	public final static String TXT_NAMEONCARD = "//div[@class='paymentContent']//input[@placeholder='Name']";
	public final static String TXT_EXPDATE = "//div[@class='paymentContent']//input[@class='form-control inputMedium cr_crd_exp']";
	public final static String TXT_CVVNUM = "//div[@class='paymentContent']//input[@class='gpayformFeildWrap inputMedium cr_cvv_no']";
	public final static String BTN_PAY = "//div[@class='paymentContent']//button[@class='button green large citipatBtn btn payNowBtn']";
	
	//Confirmation page
	public final static String LBL_ERRORMSG = "//span[@class='red lh1-5 ico14 fl width100']";
	public final static String CONFPAGE_ERRORMSG ="We are sorry but the transaction failed.";
	
	//Title page text
	public final static String TTL_HOTELHOMPAGE = "Online Hotel Booking | Book Cheap, Budget and Luxury Hotels -Goibibo";
	public final static String TTL_HOMEPAGE = "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off";
	public final static String TTL_REVIEWBOOKPAGE = "Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo";
	public final static String TTL_PAYMENTPAGE = "Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo";
	public final static String TTL_CONFIRMPAGE = "Thank you for choosing Goibibo.";
	

	
	
	
}

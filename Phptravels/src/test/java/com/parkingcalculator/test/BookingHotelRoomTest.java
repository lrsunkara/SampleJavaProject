package com.parkingcalculator.test;

import org.testng.annotations.Test;

import com.parkingcalculator.library.Base;
import com.parkingcalculator.pages.HomePage;

public class BookingHotelRoomTest extends Base {

	HomePage myHomePage = new HomePage();

@ Test
public void hotelReservation() {
	myHomePage.goto_Phptravel_Website();
	myHomePage.selectHotel();


}


}

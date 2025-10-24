package com.taxi.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.taxi.model.BookingForm;

@Service
public interface BookingFormService {

	public BookingForm saveBookingFormService(BookingForm bookingForm);

	public List<BookingForm> readAllBookings();

	public void deleteBookings(int id);

}

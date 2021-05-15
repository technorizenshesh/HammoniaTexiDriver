package com.teximobilitydriver.retrofit;




import com.teximobilitydriver.model.BookingDetailModel;
import com.teximobilitydriver.model.BrandListModel;
import com.teximobilitydriver.model.CarListModel;
import com.teximobilitydriver.model.ModListModel;
import com.teximobilitydriver.model.ModelCurrentBooking;
import com.teximobilitydriver.model.SignupModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DriverInterface {

    @GET("car_list")
    Call<CarListModel> getCarList();

    @FormUrlEncoded
    @POST("brand_list")
    Call<BrandListModel> cardBrandList(@FieldMap Map<String,String> params);


    @FormUrlEncoded
    @POST("model_list")
    Call<ModListModel> modelList(@FieldMap Map<String,String> params);



    @Multipart
    @POST("add_vehicle")
    Call<SignupModel> addVehicle (@Part("driver_id") RequestBody user_id,
                                    @Part("vehicle_type_id") RequestBody car_type_id,
                                    @Part("brand") RequestBody brand,
                                    @Part("vehicle_model") RequestBody car_model,
                                    @Part("vehicle_model_year") RequestBody year_of_manufacture,
                                    @Part("vehicle_number") RequestBody car_number,
                                    @Part("vehicle_color") RequestBody car_color,
                                    @Part MultipartBody.Part file);


    @FormUrlEncoded
    @POST("add_bank")
    Call<SignupModel> addBank(@FieldMap Map<String,String> params);



    @FormUrlEncoded
    @POST("forgot_password")
    Call<Map<String,String>> forgotPass (@FieldMap Map<String,String> params);


    @Multipart
    @POST("update_profile")
    Call<SignupModel> editprofile(
            @Part("user_id") RequestBody id,
            @Part("user_name") RequestBody first_name,
            @Part("email") RequestBody email,
            @Part("mobile") RequestBody mobile,
            @Part("phone_code") RequestBody phone_code,
            @Part MultipartBody.Part file);


    @FormUrlEncoded
    @POST("change_password")
    Call<SignupModel> changePassword (@FieldMap Map<String,String> params);


    @FormUrlEncoded
    @POST("update_lat_lon")
    Call<Map<String,String>> updateLocation (@FieldMap Map<String,String> params);

    @FormUrlEncoded
    @POST("update_online_status")
    Call<Map<String,String>> updateStatus (@FieldMap Map<String,String> params);


    @FormUrlEncoded
    @POST("driver_accept_and_Cancel_request")
    Call<BookingDetailModel>  acceptCancelRequest (@FieldMap Map<String,String> params);


    @FormUrlEncoded
    @POST("get_booking_details")
    Call<BookingDetailModel>  bookingDetails(@FieldMap Map<String,String> params);

  @FormUrlEncoded
    @POST("get_current_booking")
    Call<ModelCurrentBooking>  getCurrentBooking(@FieldMap Map<String,String> params);





}

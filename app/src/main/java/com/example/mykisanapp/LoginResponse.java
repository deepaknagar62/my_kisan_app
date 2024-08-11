package com.example.mykisanapp;

import com.example.mykisanapp.Model.Data;

public class LoginResponse {
   Data data;
   String message;

   public LoginResponse(Data data, String message) {
      this.data = data;
      this.message = message;
   }

   public Data getData() {
      return data;
   }

   public void setData(Data data) {
      this.data = data;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}

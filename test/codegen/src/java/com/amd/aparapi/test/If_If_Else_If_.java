package com.aparapi.test;

public class If_If_Else_If_{
   /*
   1:   istore_1   (0:iconst_1)
   3:   istore_2   (2:iconst_1)
   5:   istore_3   (4:iconst_0)
   7:   ifeq    19 (6:iload_1)    ?
   11:  ifeq    25 (10:iload_2)   | ?
   15:  istore_3   (14:iconst_1)  | |
   16:  goto    25                | | +
   20:  ifeq    25 (19:iload_2)   v | | ?
   24:  istore_3   (23:iconst_1)    | | |
   25:  return                      v v v
    */
   public void run() {
      boolean a = true;
      boolean b = true;
      @SuppressWarnings("unused") boolean result = false;

      if (a) {
         if (b) {
            result = true;
         }
      } else {
         if (b) {
            result = true;
         }
      }

   }
}
/**{OpenCL{
typedef struct This_s{
   
   int passid;
}This;
int get_pass_id(This *this){
   return this->passid;
   }

__kernel void run(
   int passid
){
   This thisStruct;
   This* this=&thisStruct;
   this->passid = passid;
   {
      char a = 1;
      char b = 1;
      char result = 0;
      if (a!=0){
         if (b!=0){
            result = 1;
         }
      } else {
         if (b!=0){
            result = 1;
         }
      }
      return;
   }
}
}OpenCL}**/

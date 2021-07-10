package com.hllbr.sqliteprojectfilterdetailkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
        var myDatabase = this.openOrCreateDatabase("HLLBR", MODE_PRIVATE,null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS hllbr (id INGETER PRIMARY KEY,name VARCHAR,age INT)")
            myDatabase.execSQL("INSERT INTO hllbr (name,age) VALUES('Kivas',58)")
            //var cursor = myDatabase.rawQuery("SELECT * FROM hllbr WHERE name LIKE '%s'",null)//sonu s ile biten isimleri getir demek amacıyla kurduğum  yapı
            var cursor2 = myDatabase.rawQuery("SELECT * FROM hllbr WHERE name LIKE 'K%'",null)//başında K harfi bulunan kayıtları getir
            var nameIx = cursor2.getColumnIndex("name")
            var ageIx = cursor2.getColumnIndex("age")
            var idId = cursor2.getColumnIndex("id")

            while (cursor2.moveToNext()){
                println("name : "+cursor2.getString(nameIx))
                println("age : "+cursor2.getInt(ageIx))
                println("id : "+cursor2.getInt(idId))
            }
            cursor2.close()
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}
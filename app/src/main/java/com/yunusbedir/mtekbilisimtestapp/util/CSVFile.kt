package com.yunusbedir.mtekbilisimtestapp.util
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.ui.activity.mainActivity.MainActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception


/**
 * Created by YUNUS BEDİR on 17.03.2020.
 */
class CSVFile(var inputStream: InputStream) {

    fun read(): List<String> {
        var resultList = ArrayList<String>();
        var reader = BufferedReader(InputStreamReader(inputStream));
        try {
            var line: String = reader.readLine()

            while (line != null) {
                resultList.add(line)
                try {
                    line = reader.readLine()
                }catch (e:Exception){
                    break
                }
            }

        } catch (ex: IOException) {

        } finally {
            try {
                inputStream.close();
            } catch (e: IOException) {

            }
        }
        return resultList;
    }

}
/*

fun getProvinceOfID(id: String): String {
    var list = readCSV(R.raw.il)
    list = list.filter{
        it.split(",")[0] == id
    }
    return list[0].split(",")[1]
}

fun getCityOfID(id: String): String {

    if (id != "") {
        var list = readCSV(R.raw.ilce)
        list = list.filter {
            it.split(",")[0] == id
        }
        return list[0].split(",")[2]
    }
    return ""
}

*/

fun readCSV(csvUrl: Int): List<String> {
    val inputStream: InputStream = MainActivity.activity!!.resources.openRawResource(csvUrl)
    val csvFile = CSVFile(inputStream)
    return csvFile.read()
}
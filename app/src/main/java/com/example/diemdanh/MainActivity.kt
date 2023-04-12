package com.example.diemdanh

import android.annotation.SuppressLint
import android.app.Activity

import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.diemdanh.database.AppDatabase
import com.example.diemdanh.databinding.ActivityListStudentBinding
import com.example.diemdanh.databinding.ActivityMainBinding
import com.example.diemdanh.entities.Student
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        binding?.btnInputFile?.setOnClickListener {
            openFile(it)
        }
    }

    var requestcode = 1

    // input file
    @Deprecated("Deprecated in Java")
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val context: Context = applicationContext
        if (requestCode == requestcode && resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show()
            } else {
                data.data?.also { uri ->
                    Toast.makeText(context, uri.path, Toast.LENGTH_SHORT).show()
                }
//                 var uri : Uri? = data.data
//                  path = uri?.path
//                Toast.makeText(context, uri?.path, Toast.LENGTH_SHORT).show()

                try {
                    val myInput: InputStream = contentResolver.openInputStream(data.data!!)!!
                    val myWorkBook: XSSFWorkbook = XSSFWorkbook(myInput)
                    val mySheet: XSSFSheet = myWorkBook.getSheetAt(0)
                    val rowIter: Iterator<Row> = mySheet.rowIterator()
                    var rowno: Int = 0
                    while (rowIter.hasNext()) {
                        val myRow: XSSFRow = rowIter.next() as XSSFRow
                        if (rowno != 0) {
                            val cellIter: Iterator<Cell> = myRow.cellIterator()
                            //data
                            var colno: Int = 0
//                            var stt: Int = 0
//                            var name: String = ""
//                            var ho: String = ""
//                            var ngaysinh: String = "123"
//                            var ten: String = ""
//                            var gioitinh: String = ""
                            var Student = Student()

                            while (cellIter.hasNext()) {
                                var myCell: XSSFCell = cellIter.next() as XSSFCell
                                if (colno == 1) {
                                    Student.fullName = myCell.toString()
                                }
                                colno++
                            }
                            Log.d("TAG", "" + Student.fullName)
                            AppDatabase.getInstance(this).studentDAO().insertStudent(Student)
//                            Log.d("TAG", "" + stt + "" + name + "" + ho + "" + ngaysinh)
                        }
                        rowno++
                    }
                } catch (
                    e: Exception
                ) {
                    Log.d("TAG", "onActivityResult: ${e.message}")
                }
            }
        }
    }

    fun openFile(view: View) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent, requestcode)
    }
}

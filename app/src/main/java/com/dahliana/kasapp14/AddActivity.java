package com.dahliana.kasapp14;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.dahliana.kasapp14.helper.Sqlitehelper;

public class AddActivity extends AppCompatActivity {

    RadioGroup      radio_status;
    EditText        edit_jumlah, edit_keterangan;
    Button          btn_simpan;
    RippleView      rip_simpan;

    String          status;
    Sqlitehelper    sqlitehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        status = "";
        sqlitehelper = new Sqlitehelper(this);

        radio_status = (RadioGroup) findViewById(R.id.radio_status);
        edit_jumlah = (EditText) findViewById(R.id.edit_jumlah);
        edit_keterangan = (EditText) findViewById(R.id.edit_keterangan);
        btn_simpan = (Button) findViewById(R.id.btn_simpan);
        rip_simpan = (RippleView) findViewById(R.id.rip_simpan);

        radio_status.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_masuk:
                        status = "MASUK";
                        break;
                    case R.id.radio_keluar:
                        status = "KELUAR";
                        break;
                }
                Log.d("log status", status);
            }
        });

        rip_simpan.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                if (status.equals("") || edit_jumlah.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Mohon Isi Data Dengan Benar", Toast.LENGTH_LONG).show();
                } else {
                    SQLiteDatabase database = sqlitehelper.getWritableDatabase();
                    database.execSQL("INSERT INTO transaksi(status, jumlah, keterangan) VALUES('" +
                            status + "','" +
                            edit_jumlah.getText().toString() + "','" +
                            edit_keterangan.getText().toString() + "')");

                    Toast.makeText(AddActivity.this, "Transaksi Berhasil Disimpan", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("Tambah Data");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
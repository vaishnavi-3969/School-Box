package com.myschool.myschoolbox.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    ImageView gotologin;
    EditText admission,rollnumber,sestion,fathername,mothername,gender,dob,fatherno,motherno,bloodgroup,email,mobilenumber
            ,classname,village,post,ps,pin,dis,state,contry,tutionfee,annualfee,monthlyfee,dues,totalfee,
            month,year,present,holiday,absent,leave,halfday,totalattendance,clname,one,onetotal,oneget,two,twototal,
            twoget,three,threetotal,threeget,four,fourtotale,fourget,fife,fifetotal,fifeget,six
            ,sixtotal,sixget,seven,seventotal,sevenget,eight,eighttotal,eightget,nine,ninetotal,nineget
            ,ten,tentotal,tenget,pass,password;

    Button save;
    FirebaseAuth auth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        gotologin=findViewById(R.id.gotologin);
        admission=findViewById(R.id.admissionnumber);
        rollnumber=findViewById(R.id.rollnumber);
        sestion=findViewById(R.id.sectionnumber);
        fathername=findViewById(R.id.fathername);
        mothername=findViewById(R.id.mothername);
        gender=findViewById(R.id.gender);
        dob=findViewById(R.id.dob);
        fatherno=findViewById(R.id.fnumber);
        motherno=findViewById(R.id.mnumber);
        bloodgroup=findViewById(R.id.blodgroup);
        email=findViewById(R.id.email);
        mobilenumber=findViewById(R.id.mobilenumber);
        classname=findViewById(R.id.clssname);
        village=findViewById(R.id.Place);
        post=findViewById(R.id.post);
        ps=findViewById(R.id.policestation);
        pin=findViewById(R.id.pincode);
        dis=findViewById(R.id.distic);
        state=findViewById(R.id.state);
        contry=findViewById(R.id.country);

        admission=findViewById(R.id.admissionnumber);
        month=findViewById(R.id.month);
        year=findViewById(R.id.year);
        present=findViewById(R.id.present);
        holiday=findViewById(R.id.holiday);
        absent=findViewById(R.id.absent);
        leave=findViewById(R.id.leave);
        halfday=findViewById(R.id.halfday);
        totalattendance=findViewById(R.id.totalattendance);
        clname=findViewById(R.id.clsssname);
        one=findViewById(R.id.one);
        onetotal=findViewById(R.id.tone);
        oneget=findViewById(R.id.gone);
        two=findViewById(R.id.two);
        twototal=findViewById(R.id.ttwo);
        twoget=findViewById(R.id.tget);
        three=findViewById(R.id.threee);
        threetotal=findViewById(R.id.thtotal);
        threeget=findViewById(R.id.thget);
        four=findViewById(R.id.four);
        fourtotale=findViewById(R.id.ftotal);
        fourget=findViewById(R.id.fget);
        fife=findViewById(R.id.fife);
        fifetotal=findViewById(R.id.fftotal);
        fifeget=findViewById(R.id.ffget);
        six=findViewById(R.id.six);
        sixtotal=findViewById(R.id.stotal);
        sixget=findViewById(R.id.sget);
        seven=findViewById(R.id.seven);
        seventotal=findViewById(R.id.setotal);
        sevenget=findViewById(R.id.seget);
        eight=findViewById(R.id.eight);
        eighttotal=findViewById(R.id.etotal);
        eightget=findViewById(R.id.eget);
        nine=findViewById(R.id.nine);
        ninetotal=findViewById(R.id.ntotal);
        nineget=findViewById(R.id.nget);
        ten=findViewById(R.id.ten);
        tentotal=findViewById(R.id.tetotal);
        tenget=findViewById(R.id.teget);
        pass=findViewById(R.id.pass);
        save=findViewById(R.id.register);
        password=findViewById(R.id.password);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void createUser() {
        String ad = admission.getText().toString();
        String roll = rollnumber.getText().toString();
        String sec = sestion.getText().toString();
        String fatn = fathername.getText().toString();
        String motn = mothername.getText().toString();
        String gen = gender.getText().toString();
        String date = dob.getText().toString();
        String fatno = fatherno.getText().toString();
        String motno = motherno.getText().toString();
        String blod = bloodgroup.getText().toString();
        String eml = email.getText().toString();
        String mnumber = mobilenumber.getText().toString();
        String cls = classname.getText().toString();
        String vill = village.getText().toString();
        String pst = post.getText().toString();
        String policestation = ps.getText().toString();
        String pn = pin.getText().toString();
        String ds = dis.getText().toString();
        String sta = state.getText().toString();
        String con = contry.getText().toString();
        String tut = tutionfee.getText().toString();
        String anu = annualfee.getText().toString();
        String monfee = monthlyfee.getText().toString();
        String due = dues.getText().toString();
        String tfee = totalfee.getText().toString();
        String adm = admission.getText().toString();
        String mon = month.getText().toString();
        String yr = year.getText().toString();
        String pre = present.getText().toString();
        String hol = holiday.getText().toString();
        String abs = absent.getText().toString();
        String lea = leave.getText().toString();
        String hal = halfday.getText().toString();
        String aatatandance = totalattendance.getText().toString();
        String clme = clname.getText().toString();
        String o = one.getText().toString();
        String ot = onetotal.getText().toString();
        String og = oneget.getText().toString();
        String t = two.getText().toString();
        String ttwt = twototal.getText().toString();
        String ttgt = twoget.getText().toString();
        String thr = three.getText().toString();
        String thto = threetotal.getText().toString();
        String thget = threeget.getText().toString();
        String fr = four.getText().toString();
        String fif = fife.getText().toString();
        String fift = fifetotal.getText().toString();
        String fifg = fifeget.getText().toString();
        String sx = six.getText().toString();
        String sxot = sixtotal.getText().toString();
        String sxog = sixget.getText().toString();
        String sev = seven.getText().toString();
        String sevt = seventotal.getText().toString();
        String sevg = sevenget.getText().toString();
        String eig = eight.getText().toString();
        String eigt = eighttotal.getText().toString();
        String eigtg = eightget.getText().toString();
        String nin = nine.getText().toString();
        String nint = ninetotal.getText().toString();
        String ning = nineget.getText().toString();
        String tn = ten.getText().toString();
        String tnt = tentotal.getText().toString();
        String tng = tenget.getText().toString();
        String pss = pass.getText().toString();
        String psw = password.getText().toString();
        if (TextUtils.isEmpty(eml)){
            Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(psw)){
            Toast.makeText(this, "Pass is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(eml,psw)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Usermodel usermodel=new Usermodel(ad,roll,sec,fatn,motn,gen,date,fatno,motno,blod,eml,mnumber,cls,vill,pst,policestation,pn,ds,sta,con,tut,anu,
                                    monfee,due,tfee,adm,mon,yr,pre,hol,abs,lea,hal,aatatandance,clme,o,og,t,ttwt,ttgt,
                                    thr,thto,thget,fr,fif,fift,fifg,sx,sxot,sxog,sev,sevt
                                    ,eig,eigt,eigt,nin,nint,ning,tn,tnt,tng,pss,psw);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Admin").child(id).setValue(usermodel);

                            Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
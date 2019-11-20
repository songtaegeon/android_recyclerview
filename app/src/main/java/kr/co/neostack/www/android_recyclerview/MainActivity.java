package kr.co.neostack.www.android_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    //RecyclerViewAdapter class
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activity_main.xml의 recyclerview id
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);

        //recyclerview 항목들 사이에 구분선 추가
        //수평, 수직의 스크롤 리스트 / getOrientation을 이용하여 스크롤 방향 설정
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this,linearLayoutManager.getOrientation()));

        //지정된 레이아웃매니저를 RecyclerView에 Set
        recyclerView.setLayoutManager(linearLayoutManager);

        // ArrayList에 person 객체(이름과 번호) 넣기
        List<Person> person = new ArrayList<>();
        person.add(new Person("Test","010-1234-5678"));
        person.add(new Person("NEO","010-5678-1234"));
        person.add(new Person("STACK","010-3412-7856"));
        person.add(new Person("TestPerson","123-1256-3478"));

        // Adapter생성
        recyclerViewAdapter = new RecyclerViewAdapter(this,person);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}

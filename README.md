# rv_adapter
通用的RecycleView适配器sk_rvadapter

使用方式app model下build.gradle 文件中加入如下依赖：
implementation 'com.sk.rvadapter:sk_rvadapter:1.0.1'

点击同步，如同步不成功则在项目build.gradle 文件中加入 maven { url ="https://dl.bintray.com/smarkorg/maven" } 如下：

allprojects {
repositories {
    google()
    jcenter()
    maven {
        url ="https://dl.bintray.com/smarkorg/maven"
    }
    
}
}

同步完成后则可使用
使用方法：1、新建class类，继承SkAdapter，实现构造方法与抽象渲染方法：
public class MyRecyclerViewAdapter extends SkAdapter<String> {
    private static final String TAG = "MyRecyclerViewAdapter";

    public MyRecyclerViewAdapter(Context context, List<String> list, int layoutId) {
        super(context,list,layoutId);
    }

    @Override
    public void convert(SViewHolder holder, String data) {
    }

}
  MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, mStringList, R.layout.item);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        mRecyclerView.setAdapter(adapter);
		
	2、可直接使用：
	 mRecyclerView.setAdapter(new SkAdapter(this, mStringList, R.layout.item) {
            @Override
            public void convert(SViewHolder holder, Object data) {
                
            }
        });


注：如觉得好用的话，给up点个star吧

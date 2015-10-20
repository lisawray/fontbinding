# fontbinding
An example of custom fonts in XML using [data binding](http://developer.android.com/tools/data-binding/guide.html).

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:font="@{`alegreya`}"
    />
```
<img src="https://raw.githubusercontent.com/lisawray/fontbinding/master/screenshot.png" alt="Drawing" width="400px"/>


This example includes a simple font cache that allows you to access fonts using their normal or lowercase filenames (e.g. "Roboto-Italic" or "roboto-italic" for `Roboto-Italic.otf`), or by any custom name you set. 

Make sure to use the data binding framework to inflate your layout!
```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
```

More about data binding: http://developer.android.com/tools/data-binding/guide.html


##Note: 
It's not currently possible to define custom attributes in styles using data binding. 

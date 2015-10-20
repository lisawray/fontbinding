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

Make sure your layout uses data binding, and inflate your layout using the data binding framework.
```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
```

This example includes a simple font cache.  It should work on all reasonable versions of Android!

More about data binding: http://developer.android.com/tools/data-binding/guide.html


**Note**: It's not currently possible to define custom attributes in styles using data binding.

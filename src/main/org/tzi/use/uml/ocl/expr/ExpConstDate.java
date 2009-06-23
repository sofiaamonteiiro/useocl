package org.tzi.use.uml.ocl.expr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.DateValue;
import org.tzi.use.uml.ocl.value.Value;

public class ExpConstDate extends Expression {
	
	private Date value;
	
	public ExpConstDate(Date value) {
		super(TypeFactory.mkDate());
		this.value = value;
	}
	
	@Override
	public Value eval(EvalContext ctx) {
		ctx.enter(this);
        Value res = new DateValue(value);
        ctx.exit(this, res);
        return res;
	}

	@Override
	public String toString() {
		//TODO: Move DateFormat to Options
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return df.format(value);
	}

}

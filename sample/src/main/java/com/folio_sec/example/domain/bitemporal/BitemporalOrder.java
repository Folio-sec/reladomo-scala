package com.folio_sec.example.domain.bitemporal;
import java.sql.Timestamp;
public class BitemporalOrder extends BitemporalOrderAbstract
{
	public BitemporalOrder(Timestamp businessDate
	, Timestamp processingDate
	)
	{
		super(businessDate
		,processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public BitemporalOrder(Timestamp businessDate)
	{
		super(businessDate);
	}
}

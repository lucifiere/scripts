package com.lucifiere.scripts

def tenantId ="3adas0812312312312312dsfasfas1242"
def tenantIdHashCode = Math.abs(tenantId.hashCode());
print tenantIdHashCode.mod(4) * 32 + (tenantIdHashCode / 4).longValue() % 32;
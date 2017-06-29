<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:dev="http://www.epam.by/devices" xmlns:dst="http://www.epam.by/deviceSimpleTypes">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Price list for devices computer</h2>
				
					<table border="1" >
						<tr bgcolor="#00FFFF">
							<th>Name</th>
							<th>ID</th>
							<th>Origin</th>
							<th>Price</th>
							<th>Currency type</th>
							<th>Is Peripherals</th>
							<th>Energy Consumption</th>
							<th>Has Cooler</th>
							<th>Devices Group</th>
							<th>Port Type</th>
							<th>Port ID</th>
							<th>Critical to Work</th>
						</tr>
						<xsl:for-each select="dev:devices/dev:device">
						<xsl:sort select="@dev:id"/>
						<tr bgcolor="#FFFFE0">
							<td style="text-align:center">
								<xsl:value-of select="dst:name" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="@dev:id" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:origin" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:price" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:price/@dev:currency" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:type/dst:isPeripheral" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:type/dst:energyConsumption" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:type/dst:hasCooler" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:type/dev:devicesGroup" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:type/dev:port" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dev:type/dev:port/@dev:id" />
							</td>
							<td style="text-align:center">
								<xsl:value-of select="dst:isCritical" />
							</td>		
						</tr>
						</xsl:for-each>
					</table>	
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
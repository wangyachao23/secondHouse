USE [Second_hand house]
GO
/****** Object:  Table [dbo].[transactions]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[transactions](
	[B_no] [varchar](50) NULL,
	[S_no] [varchar](50) NULL,
	[A_no] [varchar](50) NULL,
	[A_name] [varchar](50) NULL,
	[A_tel] [varchar](50) NULL,
	[orders] [varchar](50) NULL,
	[contract] [varchar](50) NULL,
	[htstyle] [varchar](50) NULL,
	[changeown] [varchar](50) NULL,
	[gjstyle] [varchar](50) NULL,
	[H_no] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Seller]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Seller](
	[S_no] [char](10) NOT NULL,
	[S_id] [char](10) NOT NULL,
	[S_name] [char](10) NOT NULL,
	[S_password] [char](10) NOT NULL,
	[S_email] [char](20) NOT NULL,
	[S_add] [char](20) NOT NULL,
	[S_tel] [nchar](20) NOT NULL,
 CONSTRAINT [PK_Seller] PRIMARY KEY CLUSTERED 
(
	[S_no] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Notice]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Notice](
	[A_no] [varchar](10) NOT NULL,
	[subject] [nchar](10) NOT NULL,
	[time] [nchar](10) NOT NULL,
	[content] [varchar](100) NULL,
	[A_sum] [nchar](10) NULL,
	[H_sum] [nchar](10) NOT NULL,
	[A_id] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Notice] PRIMARY KEY CLUSTERED 
(
	[A_no] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Houseinfo]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Houseinfo](
	[H_no] [varchar](50) NOT NULL,
	[S_no] [varchar](50) NOT NULL,
	[H_name] [varchar](50) NOT NULL,
	[reg_ad] [varchar](50) NOT NULL,
	[Item_cop] [varchar](50) NULL,
	[dir] [varchar](50) NULL,
	[Stru_na] [varchar](50) NULL,
	[area] [int] NULL,
	[floor] [int] NULL,
	[unit_no] [varchar](50) NULL,
	[cararea] [varchar](50) NULL,
	[fitment] [varchar](50) NULL,
	[serverfee] [varchar](50) NULL,
	[status] [int] NOT NULL,
	[money] [int] NOT NULL,
 CONSTRAINT [PK_Houseinfo] PRIMARY KEY CLUSTERED 
(
	[H_no] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[feedback]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[feedback](
	[B_no] [varchar](50) NULL,
	[S_no] [varchar](50) NULL,
	[buyerfk] [varchar](50) NULL,
	[sellerfk] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[contract]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[contract](
	[order_no] [int] NOT NULL,
	[progress] [varchar](50) NOT NULL,
	[con_style] [varchar](50) NOT NULL,
	[A_name] [varchar](50) NOT NULL,
	[con_time] [varchar](50) NOT NULL,
	[A_tel] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Buyer]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Buyer](
	[B_no] [char](10) NOT NULL,
	[B_id] [char](10) NOT NULL,
	[B_name] [char](10) NOT NULL,
	[B_password] [char](10) NOT NULL,
	[B_email] [char](20) NOT NULL,
	[B_add] [char](20) NOT NULL,
	[B_tel] [char](20) NOT NULL,
 CONSTRAINT [PK_Buyer] PRIMARY KEY CLUSTERED 
(
	[B_no] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'6位及以上字符' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Buyer', @level2type=N'COLUMN',@level2name=N'B_password'
GO
/****** Object:  Table [dbo].[B_order]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[B_order](
	[order_no] [int] IDENTITY(1,1) NOT NULL,
	[B_no] [varchar](20) NULL,
	[S_no] [varchar](20) NULL,
	[H_no] [varchar](20) NULL,
	[order_stu] [varchar](20) NULL,
	[S_name] [varchar](50) NULL,
	[S_tel] [varchar](50) NULL,
	[B_name] [varchar](50) NULL,
	[B_tel] [varchar](50) NULL,
 CONSTRAINT [PK_B_order] PRIMARY KEY CLUSTERED 
(
	[order_no] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 01/18/2019 13:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[A_id] [nchar](10) NOT NULL,
	[A_name] [nchar](10) NOT NULL,
	[A_tel] [nchar](20) NOT NULL,
	[A_password] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Admin_1] PRIMARY KEY CLUSTERED 
(
	[A_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Check [CK_Admin]    Script Date: 01/18/2019 13:46:31 ******/
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [CK_Admin] CHECK  ((len([A_password])>=(6)))
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [CK_Admin]
GO

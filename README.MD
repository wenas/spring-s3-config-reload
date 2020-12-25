### メモ

2.4.XからのAPIだったよ・・・。

#### spring.factories

Auto-configurationの設定を追加する。元々のSpringBootとかに書かれた設定に追加されるので、必要な分だけを追加する。

* EnableAutoConfiguration：AutoConfigurationで呼ばれるクラス
* BootstrapConfiguration：SpringCloudのBootstrap（AutoConfigurationより前に動く）で呼ばれるクラス
* ConfigDataLocationResolver：ConfigDataLoaderがアクセスするロケーションを解決するクラス
* ConfigDataLoader：設定ファイルを呼んでConfigDataを返却するクラス


#### ゴールまでにやること

* [ ] ConfigDataLoaderで適当な値を返して反映されることの確認(別にS3行かなくていいよ)
* [ ] 値を変更したらConfigDataLoaderがもう一回呼ばれることの確認（一旦10秒おきとかで動くようにする）

* [ ] ConfigDataLocationResolverにS3の接続情報べた書き
* [ ] ConfigDataLocationResolverにS3の接続情報をbootstrapあたりから読み込む

* [ ] S3とかなくても起動エラーにならないようにする





Pod::Spec.new do |s|
  s.name         = "RNReactNativeWayneBadge"
  s.version      = "1.0.0"
  s.summary      = "RNReactNativeWayneBadge"
  s.description  = <<-DESC
                  RNReactNativeWayneBadge
                   DESC
  s.homepage     = "https://www.npmjs.com/package/react-native-wayne-badge"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/wayne214/react-native-wayne-badge.git", :tag => "main" }
  s.source_files  = "**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

